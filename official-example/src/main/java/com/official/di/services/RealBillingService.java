package com.journaldev.di.services;



import com.official.di.annotations.PayPal;
import com.official.di.interfaces.BillingService;
import com.official.di.interfaces.CreditCardProcessor;
import com.official.di.interfaces.Order;
import com.official.di.interfaces.TransactionLog;
import com.official.di.model.CreditCard;
import com.official.di.model.PizzaOrder;
import com.official.di.model.Receipt;
import com.official.di.model.ChargeResult;
import com.official.di.model.UnreachableException;

import javax.inject.Inject;
import javax.inject.Named;

public class RealBillingService implements BillingService {


	private final CreditCardProcessor processor;


	private final TransactionLog transactionLog;

	@Inject
	private CreditCardProcessor ccp;

	@Inject
	@Named("Checkout")
	private CreditCardProcessor ccpNamed;



	@Inject
	public RealBillingService(@PayPal CreditCardProcessor processor, TransactionLog transactionLog) {
		this.processor = processor;
		this.transactionLog = transactionLog;
	}


	public Receipt chargeOrder(Order order, CreditCard creditCard) {
			try {
				ChargeResult result = processor.charge(creditCard, order.getAmount());
				transactionLog.logChargeResult(result);

				return result.wasSuccessful()
						? Receipt.forSuccessfulCharge(order.getAmount())
						: Receipt.forDeclinedCharge(result.getDeclineMessage());
			} catch (UnreachableException e) {
				transactionLog.logConnectException(e);
				return Receipt.forSystemFailure(e.getMessage());
			}
	}
}