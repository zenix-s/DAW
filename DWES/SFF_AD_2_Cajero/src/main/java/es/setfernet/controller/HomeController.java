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
	@GetMapping({"","/","/home"})
	public String home(HttpSession session, Model model) {
		
		String idCuenta = session.getAttribute("idCuenta") != null ? session.getAttribute("idCuenta").toString() : null;
		if(idCuenta != null)
			return "redirect:/cuenta";
		
		
		return "home";
	}
	
	@PostMapping("/logidacc")
	public String setIdAccSession(HttpSession session, @RequestParam int idCuenta)
	{
		Cuenta cuenta = cdao.findAcc(idCuenta);
		if (cuenta == null)
		{
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
