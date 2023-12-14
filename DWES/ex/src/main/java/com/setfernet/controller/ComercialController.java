package com.setfernet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comercial")
public class ComercialController {

	@GetMapping({"", "/", "/home"})
	String home() {
		return ("comercial");
	}
	
}
