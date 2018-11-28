package io.datura.java.drools.calltest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.datura.java.drools.calltest.data.Call;
import io.datura.java.drools.calltest.service.CallDAOService;

@Controller
public class CallWebController {

	@Autowired
	private CallDAOService callService;

	@GetMapping("/")
	public String getLandingPage(Model model) {
		return "index";
	}

	/* Since we haven't defined this as a RESTController, 
	 * we need to specifically configure it to generate a JSON 
	 * payload.
	 */
	@GetMapping(path = "/calls", produces = "application/json")
	public @ResponseBody Collection<Call> getCalls() {
		return callService.getAllCalls();
	}
}
