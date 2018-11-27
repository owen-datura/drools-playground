package io.datura.java.drools.calltest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.datura.java.drools.calltest.service.CallDAOService;

@Controller
public class CallWebController {

	@Autowired
	private CallDAOService callService;
	
	@GetMapping("/")
	public String getLandingPage( Model model ) {
		model.addAttribute("calls", callService.getAllCalls());
		return "index";
	}
}
