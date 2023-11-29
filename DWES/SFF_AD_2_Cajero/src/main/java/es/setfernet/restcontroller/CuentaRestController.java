package es.setfernet.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.setfernet.modelo.dao.CuentaDao;
import es.setfernet.modelo.entitybean.Cuenta;
import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/apirest/cuentas")
public class CuentaRestController {
	@Autowired
	private CuentaDao cdao;
	
	@GetMapping("/all")
	public List<Cuenta> todos()
	{
	    return cdao.findAllCuenta();
	}
	@GetMapping("/{idCuenta}")
	public Cuenta findOneAcc(@PathVariable int idCuenta)
	{
		return cdao.findAcc(idCuenta);
	}
	

}
