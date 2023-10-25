package com.setfernet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHome() {
		System.out.println("Adios mundo");
		return ("home/home");
	}
}
