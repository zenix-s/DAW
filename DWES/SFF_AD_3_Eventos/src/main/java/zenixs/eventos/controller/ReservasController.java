package zenixs.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import zenixs.eventos.model.dao.EventoDao;
import zenixs.eventos.model.dao.TipoDao;
import zenixs.eventos.model.dao.UsuarioDao;
import zenixs.eventos.model.entity.Evento;
import zenixs.eventos.model.entity.Usuario;

import org.springframework.ui.Model;
@Controller
public class ReservasController {
	
	@Autowired
	private EventoDao edao;
	@Autowired
	private TipoDao tdao;
	@Autowired
	private UsuarioDao udao;

	@GetMapping("/misReservas")
	public String misReservas(Model model) {
		model.addAttribute("eventos", edao.findAllEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		return "mainEventos";
	}

	@PostMapping("/reservar/{idEvento}")
	public String reservarEvento(@PathVariable("idEvento") int idEvento, Model model, Authentication auth, Integer cantidad) {
		Evento evento = edao.findEventoById(idEvento);
		Usuario usuario = udao.findUsuarioById(auth.getName());

		System.out.println("Reservando evento: " + evento.getNombre() + " para el usuario: " + usuario.getNombre());
		System.out.println("Cantidad: " + cantidad);
		
		return "redirect:/misReservas";
	}
}
