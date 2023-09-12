package com.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping({ "/", "/index" })
	public String index() {
		return "index";
	}
	
	//HowToUse
	@GetMapping("HowToUse")
	public String HowToUse() {
		return "HowToUse";
	}
	

	@GetMapping("setup")
	public String setup() {
		return "setup";
	}
}
