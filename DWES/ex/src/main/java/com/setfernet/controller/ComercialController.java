package com.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.setfernet.model.dao.ComercialDao;

@Controller
@RequestMapping("/comercial")
public class ComercialController {

	@Autowired
	private ComercialDao codao;
	
	@GetMapping({"", "/", "/home"})
	String home(Model model) {
		model.addAttribute("comerciales", codao.findAll());
		return ("comercial");
	}
	
}
