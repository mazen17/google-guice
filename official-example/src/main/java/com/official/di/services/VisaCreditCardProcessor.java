package com.official.di.services;


import com.official.di.interfaces.CreditCardProcessor;
import com.official.di.model.ChargeResult;
import com.official.di.model.CreditCard;

public class VisaCreditCardProcessor implements CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, double amount) {
        return null;
    }
}
