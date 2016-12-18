package com.official.di.interfaces;


import com.official.di.model.ChargeResult;
import com.official.di.model.CreditCard;

public interface CreditCardProcessor {

    ChargeResult charge(CreditCard creditCard, double amount);
}
