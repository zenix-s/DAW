package com.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.setfernet.modelo.dao.EventoDao;

@Controller
public class HomeController {
	
	@Autowired
	private EventoDao eventoDao;
	
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("eventos", eventoDao.findAllActive());
		model.addAttribute("eventosC", eventoDao.findAllNoActive());
		return ("home/home");
	}
}
