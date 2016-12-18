package com.official.di.model;

/**
 * Created by ubuntu on 10/1/16.
 */
public class ChargeResult {

    String declineMessage;

    public boolean wasSuccessful() {
        return true;
    }

    public String getDeclineMessage() {
        return declineMessage;
    }
}
