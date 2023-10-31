package com.setfernet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.setfernet.modelo.dao.EventoDao;
import com.setfernet.modelo.dao.TipoDao;
import com.setfernet.modelo.javabean.Evento;

@Controller
@RequestMapping("/events")
public class EventsController {
	
	@Autowired
	private EventoDao eventoDao;
	
	@Autowired
	private TipoDao tipoDao;
	
	@GetMapping()
	public String getEvents(Model model) {
		model.addAttribute("eventos", eventoDao.findAll());
		return ("events/home");
	}
	
	@GetMapping("/detalles/{id}")
	public String detallesEvento(@PathVariable("id") int idEvento, Model model) {
		Evento evento = eventoDao.findById(idEvento);
		if (evento != null) {
			model.addAttribute("evento", evento);
			return("events/infoEvent");
		}
		return ("events/infoEvent");
	}
	
	@GetMapping("/alta")
	public String getAltaEvento(Model model) {
		model.addAttribute("tipos", tipoDao.findAll());
		return("events/newEvent");
	}
	
	@PostMapping("/alta")
	public String postAltaEvento(Evento evento, @RequestParam("idTipo") int idTipo) {
		evento.setTipo(tipoDao.findById(idTipo));
		if(eventoDao.newEvent(evento)) return("redirect:/");
		return("redirect:/");
		
	}
	
	@GetMapping("/editar/{id}")
	public String getEditarEvento(Model model, @PathVariable("id") int idEvento) {
		Evento evento = eventoDao.findById(idEvento);
		if (evento == null) return("forward:/");
		model.addAttribute("evento", evento);
		model.addAttribute("tipos", tipoDao.findAll());
		return("events/editEvent");
	}
	
	@PostMapping("/editar/{id}")
	public String postEditarEvento(Evento evento, @PathVariable("id") int idEvento, RedirectAttributes ratt) {
		
		evento.setTipo(tipoDao.findById(evento.getTipo().getIdTipo()));
		evento.setIdEvento(idEvento);
		if(eventoDao.updateEvent(evento)) {
			ratt.addFlashAttribute("message", "Evento actualizado");
			return("redirect:/");
		}
		
		System.out.println(evento);
		return("redirect:/");
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEvento(@PathVariable("id") int idEvento, Model model) {
		if (eventoDao.deleteEvent(idEvento)) {
			model.addAttribute("message", "Evento eliminado");
			return("forward:/");
		}
		return ("forward:/");
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelarEvento(@PathVariable("id") int idEvento, Model model) {
		if (eventoDao.cancelEvent(idEvento)) {
			model.addAttribute("message", "Evento cancelado");
			return("forward:/");
		}
		return ("forward:/");
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
