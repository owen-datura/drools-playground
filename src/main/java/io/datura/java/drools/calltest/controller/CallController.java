package io.datura.java.drools.calltest.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.datura.java.drools.calltest.data.Call;
import io.datura.java.drools.calltest.rules.CallRankingService;
import io.datura.java.drools.calltest.service.CallDAOService;

@RestController
public class CallController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CallDAOService callService;
	@Autowired
	private CallRankingService rankingService;
	
	@GetMapping(path="/calls")
	public Collection<Call> getCalls() {
		return callService.getAllCalls();
	}
	
	@PostMapping(path="/calls/filterByRuleSet/{filterId}")
	public Collection<Call> filterByRuleSet(@PathVariable int filterId) {
		callService.resetCallData();
		
		for( Call c : callService.getAllCalls()) {
			rankingService.rankCall(c);
		}

		return callService.getAllCalls();
	}
	
	@PostMapping(path="/calls/reset")
	public Collection<Call> resetCallState() {
		log.warn("Resetting call data to defaults.");
		callService.resetCallData();
		return callService.getAllCalls();
	}
}
