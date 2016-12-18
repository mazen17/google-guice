package com.journaldev.di.test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.journaldev.di.consumer.MyApplication;
import com.journaldev.di.services.RealBillingService;
import com.official.di.injector.BillingModule;
import com.official.di.interfaces.BillingService;
import com.official.di.interfaces.CreditCardProcessor;

import javax.inject.Inject;

public class ClientApplication {



	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new BillingModule());


		BillingService billingService = injector.getInstance(BillingService.class);
		System.out.print("test");

	}


}
