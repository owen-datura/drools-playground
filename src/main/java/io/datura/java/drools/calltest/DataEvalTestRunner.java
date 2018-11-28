package io.datura.java.drools.calltest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.datura.java.drools.calltest.data.Call;
import io.datura.java.drools.calltest.rules.CallRankingService;
import io.datura.java.drools.calltest.service.CallDAOService;

@Component
public class DataEvalTestRunner implements CommandLineRunner {
	@Autowired
	CallDAOService callService;
	@Autowired
	CallRankingService rankService;
	
	@Override
	public void run(String... args) throws Exception {
		String fmt = "Caller %s %s was in rank %s";
		
		Collection<Call> calls = callService.getAllCalls();
		for( Call call : calls ) {
			System.out.println(String.format(fmt, call.getCallerDemo().getFirstName(), call.getCallerDemo().getLastName(), call.getCallRank()));
			rankService.rankCall(call);
			System.out.println(String.format(fmt, call.getCallerDemo().getFirstName(), call.getCallerDemo().getLastName(), call.getCallRank()));
		}
	}

}
