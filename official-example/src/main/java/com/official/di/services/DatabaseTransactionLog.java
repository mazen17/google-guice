package com.official.di.services;

import com.official.di.interfaces.TransactionLog;
import com.official.di.model.ChargeResult;
import com.official.di.model.UnreachableException;

import java.sql.Connection;


public class DatabaseTransactionLog implements TransactionLog{

    private Connection connection;
    private String jdbcUrl;
    private int threadPoolSize;

    public void logChargeResult(ChargeResult result) {

    }

    public void logConnectException(UnreachableException e) {

    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
