package io.datura.java.drools.calltest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CallWebController {

	@GetMapping("/")
	public String getLandingPage( Model model ) {
		return "index";
	}
}
