package zenixs.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import zenixs.eventos.model.dao.EventoDao;
import zenixs.eventos.model.dao.ReservaDao;
import zenixs.eventos.model.dao.TipoDao;
import zenixs.eventos.model.dao.UsuarioDao;
import zenixs.eventos.model.entity.Evento;
import zenixs.eventos.model.entity.Reserva;
import zenixs.eventos.model.entity.Usuario;

import org.springframework.ui.Model;
@Controller
@RequestMapping("/eventos")
public class ReservasController {
	
	@Autowired
	private EventoDao edao;
	@Autowired
	private TipoDao tdao;
	@Autowired
	private UsuarioDao udao;
	@Autowired
	private ReservaDao rdao;

	@GetMapping("/misReservas")
	public String misReservas(Model model, RedirectAttributes ratt, Authentication auth) {

		// filter reservas where evento.fechaInicio > now
		List<Reserva> reservas = rdao.findAllReservaByIdUsuarioAndFechaInicio(auth.getName());

		model.addAttribute("reservas", reservas);
		model.addAttribute("tipos", tdao.findAllTipo());

		return "misReservas";
	}

	@PostMapping("/reservar/{idEvento}")
	public String reservarEvento(@PathVariable("idEvento") int idEvento, Model model, Authentication auth, Integer cantidad, RedirectAttributes ratt) {
		if (cantidad == null || cantidad <= 0 || cantidad > 10) {
			ratt.addFlashAttribute("errorMessage", "Cantidad invalida");
			return "redirect:/eventos/misReservas";
		}
		Reserva reserva = new Reserva();
		Evento evento = edao.findEventoById(idEvento);
		Usuario usuario = udao.findUsuarioById(auth.getName());
		Integer cantidadReservada = rdao.sumCantidadByIdEventoAndIdUsuario(idEvento, auth.getName());
		Integer cantidadReservadaTotal = rdao.sumCantidadByIdEvento(idEvento);

		if (cantidadReservadaTotal == null)
			cantidadReservadaTotal = 0;

		if (evento.getAforoMaximo() < (cantidadReservadaTotal + cantidad)) {
			ratt.addFlashAttribute("errorMessage", "No hay suficientes entradas, aforo maximo: " + evento.getAforoMaximo() + " cantidad reservada: " + cantidadReservadaTotal + " cantidad que se puede reservar: " + (evento.getAforoMaximo() - cantidadReservadaTotal));
			return "redirect:/eventos/misReservas";
		}

		if (cantidadReservada == null)
			cantidadReservada = 0;

		if ((cantidadReservada + cantidad)> 10) {
			ratt.addFlashAttribute("errorMessage", "No se puede reservar mas de 10 entradas, cantidad que se puede reservar: " + (10 - cantidadReservada));
			return "redirect:/eventos/misReservas";
		}

		reserva.setEvento(evento);
		reserva.setUsuario(usuario);
		reserva.setCantidad(cantidad);
		reserva.setPrecioVenta(evento.getPrecio());
		reserva.setObservaciones("Reserva de evento" + evento.getNombre());
		
		if (rdao.insertReserva(reserva) == 1) {
			// System.out.println("Reserva exitosa");
			ratt.addFlashAttribute("successMessage", "Reserva exitosa");
			return "redirect:/eventos/misReservas";
		} else {
			// System.out.println("Reserva fallida");
			ratt.addFlashAttribute("errorMessage", "Reserva fallida");
			return "redirect:/eventos/misReservas";
		}
	}

	@GetMapping("/cancelar/{idReserva}")
	public String cancelarReserva(@PathVariable("idReserva") int idReserva, Model model, RedirectAttributes ratt) {
		if (rdao.deleteReserva(idReserva) == 1) {
			ratt.addFlashAttribute("successMessage", "Reserva cancelada");
			return "redirect:/eventos/misReservas";
		} else {
			ratt.addFlashAttribute("errorMessage", "Error al cancelar reserva");
			return "redirect:/eventos/misReservas";
		}
	}

}
