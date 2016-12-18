package com.official.di.model;

/**
 * Created by ubuntu on 10/1/16.
 */
public class Receipt {

    public static Receipt forSuccessfulCharge(double amount) {
        return null;
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return null;
    }

    public static Receipt forSystemFailure(String message) {
        return null;
    }
}
