package es.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.setfernet.modelo.dao.CuentaDao;
import es.setfernet.modelo.entitybean.Cuenta;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private CuentaDao cdao;
	/**
	 * Gestiona las peticiones get a las rutas / /home, comprueba si ya existe un idCuenta y que esta sea valido
	 * Si ese es el caso nos redirije a la dirección /cuenta
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping({"","/","/home"})
	public String home(HttpSession session, Model model) {
		
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if(idCuenta == null)
			return "home";
		Cuenta cuenta = cdao.findAcc(Integer.parseInt(idCuenta));
		if (cuenta != null)
			return ("redirect:/cuenta");		
		return "home";
	}
	
	/**
	 * Recibe el id de una cuenta y si este es valido lo carga en el atributo session
	 * @param session
	 * @param idCuenta - El id de la cuenta en la cual se quieren realizar las operaciones
	 * @param ratt
	 * @return
	 */
	@PostMapping("/logidacc")
	public String setIdAccSession(HttpSession session, @RequestParam int idCuenta, RedirectAttributes ratt)
	{
		Cuenta cuenta = cdao.findAcc(idCuenta);
		if (cuenta == null)
		{
			ratt.addFlashAttribute("error", "No se ha podido conectar con la cuenta especificada - Cuenta no existe");
	
			return ("redirect:/");
		}
		
		session.setAttribute("idCuenta", idCuenta);
		return ("redirect:/cuenta");
	}
	@GetMapping("/endidacc")
	public String endIdAccSession(HttpSession session)
	{
		session.removeAttribute("idCuenta");
		return ("redirect:/");
	}
}
