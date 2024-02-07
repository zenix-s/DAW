package zenixs.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import zenixs.eventos.model.dao.EventoDao;
import zenixs.eventos.model.dao.TipoDao;

import org.springframework.ui.Model;
@Controller
public class ReservasController {
	
	@Autowired
	private EventoDao edao;
	@Autowired
	private TipoDao tdao;

	@GetMapping("/misReservas")
	public String misReservas(Model model) {
		model.addAttribute("eventos", edao.findAllEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		return "mainEventos";
	}
}
