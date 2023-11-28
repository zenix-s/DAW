package es.setfernet.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.setfernet.modelo.dao.MovimientoDao;
import es.setfernet.modelo.entitybean.Movimiento;

@RestController
@RequestMapping("/apirest/movimientos")
public class MovimientosRestController {
	@Autowired
	private MovimientoDao mdao;
	
	@GetMapping("/all")
	public List<Movimiento> todos()
	{
	    return mdao.findAllMov();
	}
	
	@GetMapping("/all/{idCuenta}")
	public List<Movimiento> allById(@PathVariable int idCuenta)
	{
		return mdao.findAllMovById(idCuenta);
	}

	@PostMapping("/new")
	public Movimiento nuevo(@RequestBody Movimiento movimiento)
	{
		return mdao.insertMov(movimiento);
	}
}
