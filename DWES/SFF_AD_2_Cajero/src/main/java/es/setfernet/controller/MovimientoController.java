package es.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.setfernet.modelo.dao.CuentaDao;
import es.setfernet.modelo.dao.MovimientoDao;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cuenta")
public class MovimientoController {
	@Autowired
	private MovimientoDao mdao;
	@Autowired
	private CuentaDao cdao;
	
	@GetMapping()
	public String homeAcc()
	{
		return "cuenta/home";
	}
	@GetMapping("/movimientos")
	public String movAcc(HttpSession session, Model model)
	{
		model.addAttribute("idCuenta", session.getAttribute("idCuenta").toString());
		model.addAttribute("movimientos", mdao.findAllMovById(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		model.addAttribute("cuenta", cdao.findAcc(Integer.parseInt(session.getAttribute("idCuenta").toString())));
		return "cuenta/movimientos";
	}
}
