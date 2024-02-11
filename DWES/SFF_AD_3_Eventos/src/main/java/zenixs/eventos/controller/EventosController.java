package zenixs.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zenixs.eventos.model.dao.EventoDao;
import zenixs.eventos.model.dao.ReservaDao;
import zenixs.eventos.model.dao.TipoDao;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventoDao edao;
	@Autowired
	private TipoDao tdao;
	@Autowired
	private ReservaDao rdao;


	/**
	 * Listar todos los eventos con atributo activo
	 * @param model
	 * @return mainEventos.html
	 */
	@GetMapping("/activos")
	public String isActive(Model model) {

		model.addAttribute("eventos", edao.findAllActiveEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		return "mainEventos";
	}

	/**
	 * Listar todos los eventos con atributo destacado
	 * @param model
	 * @return mainEventos.html
	 */
	@GetMapping("/destacados")
	public String destacados(Model model) {

		model.addAttribute("eventos", edao.findAllDestacadoEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		return "mainEventos";
	}

	/**
	 * Detalle de un evento
	 * @param model
	 * @param id id del evento
	 * @return detalleEvento.html
	 */
	@GetMapping("/verUno/{id}")
	public String viewOne(Model model, @PathVariable(name = "id") int id) {

		model.addAttribute("evento", edao.findEventoById(id));
		Integer cantidadReservada = rdao.sumCantidadByIdEvento(id) == null ? 0 : rdao.sumCantidadByIdEvento(id);
		model.addAttribute("cantidadReservada", cantidadReservada);
		
		return "detalleEvento";
	}

}
