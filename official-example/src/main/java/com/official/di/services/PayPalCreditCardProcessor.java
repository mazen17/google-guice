package com.official.di.services;


import com.official.di.interfaces.CreditCardProcessor;
import com.official.di.model.ChargeResult;
import com.official.di.model.CreditCard;

import javax.inject.Named;

public class PayPalCreditCardProcessor implements CreditCardProcessor {


    private String apiKey;

    public ChargeResult charge(CreditCard creditCard, double amount) {
        return null;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
