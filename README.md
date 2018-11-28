# drools-playground
This simple Spring Web app incorporates the Drools rule engine and attempts to demonstrate how
* a rules/facts file can be applied to data objects
* how the evaluation of those rules can be done via a web interface.

The rules file is present in `resources/rules/call_ranking.drl` and has the following contents:

```
rule "Large Company With Networking"
	when
		$c : Call()
		CallerDemographics( companySize == CallerDemographics.CompanySize.ONE_HUNDRED_TO_1000 ||
			companySize == CallerDemographics.CompanySize.OVER_1000 )
		CallerProducts( ownedProducts contains CallerProducts.Products.SWITCHES_GIG_E ||
			ownedProducts contains CallerProducts.Products.SWITCHES_10_GIG_E )		
	then
		$c.setCallRank(Call.CallRank.FULLY_QUALIFIED);
end

rule "American Company With On-Premises Servers"
	when
		$c : Call()
		CallerDemographics( callingRegion == CallerDemographics.Region.NORTH_AMERICA ||
			callingRegion == CallerDemographics.Region.CENTRAL_AMERICA ||
			callingRegion == CallerDemographics.Region.SOUTH_AMERICA )
		CallerProducts( ownedProducts contains CallerProducts.Products.ON_PREM_SERVERS )
	then
		$c.setCallRank(Call.CallRank.UPSELL_VIRTUAL_MACHINES);
end
```

## TODO
* Split the rules present in the ruleset file so they can be fired individually. 
* Localization for enum output.