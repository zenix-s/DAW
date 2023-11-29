package es.setfernet.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.setfernet.modelo.dao.CuentaDao;
import es.setfernet.modelo.dao.MovimientoDao;
import es.setfernet.modelo.entitybean.Cuenta;
import es.setfernet.modelo.entitybean.Movimiento;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cuenta")
public class CuentaController {
	@Autowired
	private CuentaDao cdao;
	@Autowired
	private MovimientoDao mdao;

	/**
	 * Se encarga de cargar la pagina de cuenta
	 * @param model 	objeto de la clase Model
	 * @param session	objeto de la clase HttpSession
	 * @return	la pagina de la cuenta, en caso de no tener un idCuenta valido vuelve a /
	 */
	@GetMapping({"","/","/home"})
	public String homeAcc(Model model, HttpSession session) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		model.addAttribute("idCuenta", idCuenta);
		model.addAttribute("cuenta", cdao.findAcc(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		return "cuenta/home";
	}

	/**
	 * Se encarga de agregar una cantidad de saldo a la cuenta
	 * @param session		objeto de la clase HttpSession
	 * @param ingresosaldo	Cantidad de saldo que sera añadida a la cuenta
	 * @param ratt			Objeto de la clase RedirectAttributes
	 * @return	Se rederidige hacia /cuenta si no encuentra un id valido vuelve a /
	 */
	@PostMapping("/addSaldo")
	public String updateAccAddSaldo(HttpSession session, @RequestParam("ingresosaldo") double ingresosaldo, RedirectAttributes ratt) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		Cuenta cuenta = cdao.findAcc(Integer.parseInt(idCuenta));
		cuenta.setSaldo(cuenta.getSaldo() + ingresosaldo);
		cdao.updateAcc(cuenta);
		Movimiento movimiento = new Movimiento(ingresosaldo, cuenta, new Date(), "Abono");
		ratt.addFlashAttribute("mensaje", "Saldo ingresado a la cuenta: " + Double.toString(ingresosaldo) + "€");
		mdao.insertMov(movimiento);
		return "redirect:/cuenta";
	}

	/**
	 * Se encarga de retirar una cantidad de saldo a la cuenta
	 * @param session		Objeto de la calse HttpSession
	 * @param extraersaldo	Cantidad de saldo que sera retirada de la cuenta
	 * @param ratt			Objeto de la clase RedirectAttributes
	 * @return	Se redirige hacia la pagina /cuenta si todo ha salido de manera correcta si no encuantra un id valido se rederidije hacia /
	 */
	@PostMapping("/resSaldo")
	public String updateAccResSaldoc(HttpSession session, @RequestParam("extraersaldo") double extraersaldo, RedirectAttributes ratt) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		Cuenta cuenta = cdao.findAcc(Integer.parseInt(idCuenta));

		if (cuenta.getSaldo() < extraersaldo)
		{
			ratt.addFlashAttribute("mensaje", "Saldo insuficiente");
			return "redirect:/cuenta";
		}

		cuenta.setSaldo(cuenta.getSaldo() - extraersaldo);
		cdao.updateAcc(cuenta);
		Movimiento movimiento = new Movimiento(extraersaldo, cuenta, new Date(), "cargo");
		mdao.insertMov(movimiento);
		ratt.addFlashAttribute("mensaje", "Saldo extraido de la cuenta: " + Double.toString(extraersaldo) + "€");
		return "redirect:/cuenta";
	}

	/**
	 * Se encarga de cargar la pagina de movimientos
	 * @param session	Objeto de la clase HttpSession
	 * @param model		Objeto de la clase Model
	 * @return	la pagina cuenta/movimientos y si no hay id se redirige hacia /
	 */
	@GetMapping("/movimientos")
	public String movAcc(HttpSession session, Model model) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		model.addAttribute("idCuenta", idCuenta);
		model.addAttribute("movimientos",
				mdao.findAllMovById(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		model.addAttribute("cuenta", cdao.findAcc(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		return "cuenta/movimientos";
	}

	/**
	 * Se encarga de cargar la pagina de ingresarSaldo
	 * @param session	Objeto de la clase HttpSession
	 * @param model		Objeto de la clase Model
	 * @return	la pagina cuenta/ingresarSaldo y si no hay id se redirige hacia /
	 */
	@GetMapping("/ingresar")
	public String ingresarSaldo(HttpSession session, Model model) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		model.addAttribute("idCuenta", idCuenta);
		model.addAttribute("cuenta", cdao.findAcc(Integer.parseInt(session.getAttribute("idCuenta").toString())));

		return "cuenta/ingresarSaldo";
	}

	/**
	 * Se encarga de cargar la pagina de extraerSaldo
	 * @param session	Objeto de la clase HttpSession
	 * @param model		Objeto de la clase Model
	 * @return	la pagina cuenta/extraerSaldo y si no hay id se redirige hacia /
	 */
	@GetMapping("/extraer")
	public String extraerSaldo(HttpSession session, Model model) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		model.addAttribute("idCuenta", idCuenta);
		model.addAttribute("cuenta", cdao.findAcc(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		return "cuenta/extraerSaldo";
	}

	/**
	 * 
	 * @param session		Objeto de la clase HttpSession
	 * @param saldo			El saldo que se va a transferir
	 * @param destIdAcc		EL id de la cuenta destino
	 * @param ratt			Objeto de la clase RedirectAttributes
	 * @return				Se redirije hacia /cuenta
	 */
	@PostMapping("/transferencia")
	public String trasferenciaSaldo(HttpSession session, @RequestParam("saldo") double saldo,
			@RequestParam("destAcc") int destIdAcc, RedirectAttributes ratt) {
		// Se obtiene el id de la cuenta actual del atributo session
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		
		// Se verifica si existe un id autenticado
		if (idCuenta == null)
			return "redirect:/";
		
		// Se verifica que la cuenta de destino exista
		if (cdao.findAcc(destIdAcc) == null)
		{
			ratt.addFlashAttribute("mensaje", "La cuenta especificada no existe");
			return "redirect:/cuenta";
		}

		// Se verifica si la cuenta de destino y de origen no son la misma
		if (Integer.parseInt(idCuenta) == destIdAcc)
			return "redirect:/cuenta";

		// Se obtine la cuenta de origen
		Cuenta cuentaOrigen = cdao.findAcc(Integer.parseInt(idCuenta));
		
		// Se comprueba si hay suficiente saldo en la cuenta de origen para hacer la trasferencia
		if (cuentaOrigen.getSaldo() < saldo)
		{
			ratt.addFlashAttribute("mensaje", "Saldo insuficiente");
			return "redirect:/cuenta";
		}
		
		// Se obtiene la cuenta de destino
		Cuenta cuentaDestino = cdao.findAcc(destIdAcc);

		// Se realiza la trasferencia eliminando la cantidad de saldo en el origen y añadiendola al destino
		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - saldo);
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + saldo);
		cdao.updateAcc(cuentaDestino);
		cdao.updateAcc(cuentaOrigen);

		// Se generan los movimientos correspondientes en cada cuenta
		Movimiento movimientoorigen = new Movimiento(saldo, cdao.findAcc(Integer.parseInt(idCuenta)), new Date(),
				"Cargo por transferencia");
		mdao.insertMov(movimientoorigen);
		Movimiento movimientodestino = new Movimiento(saldo, cdao.findAcc(destIdAcc), new Date(),
				"Abono por transferencia");
		mdao.insertMov(movimientodestino);
		
		ratt.addFlashAttribute("mensaje", "Se han transferido " + saldo + "€ de saldo a cuenta con id " + destIdAcc);

		// Se Vuelve a la cuenta
		return "redirect:/cuenta";

	}
	
	/**
	 * Se encarga de cargar la pagina de transferencia
	 * @param session	Objeto de la clase HttpSession
	 * @param model		Objeto de la clase Model
	 * @return	la pagina cuenta/transferencia y si no hay id se redirige hacia /
	 */
	@GetMapping("/transferencia")
	public String trasferenciaSaldo(Model model, HttpSession session) {
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if (idCuenta == null)
			return "redirect:/";
		model.addAttribute("idCuenta", idCuenta);
		model.addAttribute("cuenta", cdao.findAcc(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		return "cuenta/transferenciaSaldo";
	}

}
