package com.official.di.interfaces;


import com.official.di.model.ChargeResult;
import com.official.di.model.UnreachableException;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);


}
