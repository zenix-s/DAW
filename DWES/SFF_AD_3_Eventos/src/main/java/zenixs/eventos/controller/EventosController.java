package zenixs.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zenixs.eventos.model.dao.EventoDao;
import zenixs.eventos.model.dao.TipoDao;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventoDao edao;
	@Autowired
	private TipoDao tdao;

	@GetMapping("/activos")
	public String isActive(Model model) {
		
		model.addAttribute("eventos", edao.findAllActiveEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		return "mainEventos";
	}
	
	@GetMapping("/destacados")
	public String isHighlighted(Model model) {
		
		model.addAttribute("eventos", edao.findAllDestacadoEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		return "mainEventos";
	}

	@GetMapping("/verUno/{id}")
	public String viewOne(Model model, @PathVariable(name="id") int id) {
		
		model.addAttribute("evento", edao.findEventoById(id));
		return "detalleEvento";
	}

}
