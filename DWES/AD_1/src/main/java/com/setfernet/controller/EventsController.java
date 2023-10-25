package com.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.setfernet.modelo.dao.EventoDao;
import com.setfernet.modelo.dao.ImplementEventoDao;
import com.setfernet.modelo.javabean.Evento;

@Controller
@RequestMapping("/events")
public class EventsController {
	
	@Autowired
	private EventoDao eventoDao;
	
	@GetMapping()
	public String getEvents(Model model) {
		model.addAttribute("eventos", eventoDao.findAll());
		return ("events/home");
	}
	
	@GetMapping("/editar/{id}")
	public String editarEvento(@PathVariable("id") int idEvento, Model model) {
		Evento evento = eventoDao.findById(idEvento);
		System.out.println("hola pepe");
		if (evento != null) {
			model.addAttribute("evento", evento);
			return("events/infoEvent");
		}
		return ("events/infoEvent");
	}
	
}
