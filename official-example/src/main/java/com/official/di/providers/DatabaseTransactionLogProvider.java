package com.official.di.providers;

import com.official.di.interfaces.TransactionLog;
import com.official.di.services.DatabaseTransactionLog;

import javax.inject.Inject;
import javax.inject.Provider;
import java.sql.Connection;

public class DatabaseTransactionLogProvider implements Provider<TransactionLog> {



    public TransactionLog get() {
            DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();

        return transactionLog;
    }
}