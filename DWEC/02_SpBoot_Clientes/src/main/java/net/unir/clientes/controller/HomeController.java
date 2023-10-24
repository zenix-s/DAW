package net.unir.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import net.unir.clientes.modelo.dao.ClienteDao;

@Controller
public class HomeController {
	@Autowired
	private ClienteDao cdao;
	
	@GetMapping("/")
	public String ShowHome(Model model) {
		model.addAttribute("clientes", cdao.findAll());
		return ("home");
	}
}
