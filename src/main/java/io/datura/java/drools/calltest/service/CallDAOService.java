package io.datura.java.drools.calltest.service;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.datura.java.drools.calltest.data.Call;
import io.datura.java.drools.calltest.data.CallerDemographics;
import io.datura.java.drools.calltest.data.CallerDemographics.CompanySize;
import io.datura.java.drools.calltest.data.CallerDemographics.Region;
import io.datura.java.drools.calltest.data.CallerProducts.Products;
import io.datura.java.drools.calltest.data.CallerProducts;

@Service
public class CallDAOService {
	private static Collection<Call> loadedCalls = new ArrayList<>();

	/* Manually define some data. */
	static {
		loadedCalls = setDefaultData();
	}
	
	public Collection<Call> getAllCalls() {
		return Collections.unmodifiableCollection(loadedCalls);
	}

	public void resetCallData() {
		loadedCalls = setDefaultData();
	}
	
	private static Collection<Call> setDefaultData() {
		Collection<Call> calls = new ArrayList<>();
		long curId = 1l;

		{
			Call c1 = new Call(curId++, Call.getRandomizedTime());
			// get + set the demo data
			CallerDemographics cd1 = c1.getCallerDemo();
			cd1.setFirstName("George");
			cd1.setLastName("Romero");
			cd1.setPhoneNumber("555-121-3344");
			cd1.setEmailAddress("g.romero@romerosoft.edu");
			cd1.setCallingRegion(Region.CENTRAL_AMERICA);
			cd1.setCompanySize(CompanySize.TEN_TO_ONE_HUNDRED);
			// get + set the product data
			CallerProducts cp1 = c1.getProducts();
			cp1.addProduct(Products.ON_PREM_SERVERS);
			cp1.addProduct(Products.SWITCHES_10_GIG_E);
			calls.add(c1);
		}

		{
			Call c2 = new Call(curId++, Call.getRandomizedTime());
			// get + set the demo data
			CallerDemographics cd2 = c2.getCallerDemo();
			cd2.setFirstName("Robert");
			cd2.setLastName("Smith");
			cd2.setPhoneNumber("555-447-1817");
			cd2.setEmailAddress("robertsmith@aol.com");
			cd2.setCallingRegion(Region.ASIA);
			cd2.setCompanySize(CompanySize.ONE_HUNDRED_TO_1000);
			// get + set the product data
			CallerProducts cp2 = c2.getProducts();
			cp2.addProduct(Products.INTRUSION_MONITORING);
			cp2.addProduct(Products.EC2_INSTANCES);
			calls.add(c2);
		}

		{
			Call c3 = new Call(curId++, Call.getRandomizedTime());
			CallerDemographics cd3 = c3.getCallerDemo();
			cd3.setFirstName("Aimee");
			cd3.setLastName("Mann");
			cd3.setPhoneNumber("555-383-1192");
			cd3.setEmailAddress("kittenluvr227@gmail.com");
			cd3.setCallingRegion(Region.NORTH_AMERICA);
			cd3.setCompanySize(CompanySize.OVER_1000);
			// get + set the product data
			CallerProducts cp3 = c3.getProducts();
			cp3.addProduct(Products.INTRUSION_MONITORING);
			cp3.addProduct(Products.EC2_INSTANCES);
			cp3.addProduct(Products.SWITCHES_GIG_E);
			calls.add(c3);
		}

		{
			Call c4 = new Call(curId++, Call.getRandomizedTime());
			CallerDemographics cd4 = c4.getCallerDemo();
			cd4.setFirstName("Phil");
			cd4.setLastName("Spector");
			cd4.setPhoneNumber("555-995-2797");
			cd4.setEmailAddress("wallofsnd@specops.org");
			cd4.setCallingRegion(Region.NORTH_AMERICA);
			cd4.setCompanySize(CompanySize.ONE_TO_TEN);
			// get + set the product data
			CallerProducts cp4 = c4.getProducts();
			cp4.addProduct(Products.SWITCHES_10_GIG_E);
			cp4.addProduct(Products.VOIP_PHONES);
			cp4.addProduct(Products.SWITCHES_GIG_E);
			calls.add(c4);
		}

		{
			Call c5 = new Call(curId++, Call.getRandomizedTime());
			CallerDemographics cd5 = c5.getCallerDemo();
			cd5.setFirstName("Slavoj");
			cd5.setLastName("Zizek");
			cd5.setPhoneNumber("555-223-8972");
			cd5.setEmailAddress("idprefernotto@analysis.co.uk");
			cd5.setCallingRegion(Region.SOUTH_AMERICA);
			cd5.setCompanySize(CompanySize.ONE_TO_TEN);
			// get + set the product data
			CallerProducts cp5 = c5.getProducts();
			cp5.addProduct(Products.ON_PREM_SERVERS);
			calls.add(c5);
		}
		
		return calls;
	}
}
