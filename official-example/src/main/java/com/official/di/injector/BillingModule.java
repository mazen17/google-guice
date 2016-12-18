package com.official.di.injector;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.journaldev.di.services.RealBillingService;
import com.official.di.annotations.PayPal;
import com.official.di.interfaces.BillingService;
import com.official.di.interfaces.CreditCardProcessor;
import com.official.di.interfaces.TransactionLog;
import com.official.di.providers.DatabaseTransactionLogProvider;
import com.official.di.services.*;

import javax.inject.Named;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {

     /*
      * This tells Guice that whenever it sees a dependency on a TransactionLog,
      * it should satisfy the dependency using a DatabaseTransactionLog.
      */
       // bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        //bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);
        bind(TransactionLog.class).toProvider(DatabaseTransactionLogProvider.class);

     /*
      * Similarly, this binding tells Guice that when CreditCardProcessor is used in
      * a dependency, that should be satisfied with a PaypalCreditCardProcessor.
      */
       // bind(CreditCardProcessor.class).to(PayPalCreditCardProcessor.class);
        bind(CreditCardProcessor.class).to(VisaCreditCardProcessor.class);
      //  bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class);


        bind(CreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class);

        bind(BillingService.class).to(RealBillingService.class);

        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("test");


    }


    /*@Provides
    TransactionLog provideTransactionLog() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        transactionLog.setJdbcUrl("jdbc:mysql://localhost/pizza");
        transactionLog.setThreadPoolSize(30);
        return transactionLog;
    }*/

    @Provides @PayPal
    CreditCardProcessor providePayPalCreditCardProcessor(@Named("apiKey")
             String apiKey) {
        PayPalCreditCardProcessor processor = new PayPalCreditCardProcessor();
        processor.setApiKey(apiKey);
        return processor;
    }
}