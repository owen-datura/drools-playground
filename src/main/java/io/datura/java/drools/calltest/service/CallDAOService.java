package io.datura.java.drools.calltest.service;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import io.datura.java.drools.calltest.data.Call;
import io.datura.java.drools.calltest.data.CallerDemographics;
import io.datura.java.drools.calltest.data.CallerDemographics.CompanySize;
import io.datura.java.drools.calltest.data.CallerDemographics.Region;
import io.datura.java.drools.calltest.data.CallerProducts.Products;
import io.datura.java.drools.calltest.data.CallerProducts;

@Component
public class CallDAOService {
	private static Collection<Call> calls = new ArrayList<>();
	
	public Collection<Call> getAllCalls() {
		return Collections.unmodifiableCollection(calls);
	}
	
	/* Manually define some data. */
	static {
		{
			Call c1 = new Call(Call.getRandomizedTime());
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
			cp1.addProduct(Products.SERVERS);
			calls.add(c1);
		}

		{
			Call c2 = new Call(Call.getRandomizedTime());
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
			Call c3 = new Call(Call.getRandomizedTime());
			CallerDemographics cd3 = c3.getCallerDemo();
			cd3.setFirstName("Amy");
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
			Call c4 = new Call(Call.getRandomizedTime());
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
	}
}
