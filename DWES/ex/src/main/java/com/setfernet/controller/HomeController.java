package com.setfernet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@GetMapping({"","/","/home"})
	public String home(HttpSession session) {
		String name = session.getAttribute("name") != null ? session.getAttribute("name").toString() : null;
 		if (name == null)
 			return ("home");
		return "redirect:/pedido";
	}
	@PostMapping("/logacc")
	public String login(HttpSession session, @RequestParam String name) {
		session.setAttribute("name", name);
		return ("redirect:/");
	}
}
