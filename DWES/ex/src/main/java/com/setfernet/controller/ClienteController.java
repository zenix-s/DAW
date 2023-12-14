package com.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.setfernet.model.dao.ClienteDao;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteDao cdao;
	
	@GetMapping({"","/","/home"})
	public String home(Model model) {
		System.out.println("hola");
		System.out.println(cdao.findAll());
		model.addAttribute("clientes", cdao.findAll());
		model.addAttribute("mensaje", "esto no esta bien");
		return ("clientes");
	}
}
