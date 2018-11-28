package io.datura.java.drools.calltest.rules;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datura.java.drools.calltest.data.Call;

@Service
public class CallRankingService {
	
	@Autowired
	private KieContainer kieContainer;
	
	public void rankCall( final Call call ) {
		KieSession session = kieContainer.newKieSession();
		// TODO: Had some trouble referencing nested classes
		// within the .drl file, not sure if I'm unclear on the 
		// syntax or not. Some research showed some recommendations
		// to just set all the relevant details in the rule engine,
		// so that's what I'm doing here.
		session.insert(call);
		session.insert(call.getCallerDemo());
		session.insert(call.getProducts());
		session.fireAllRules();
	}
}
