package zenixs.ad4.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zenixs.ad4.model.entity.Comercial;
import zenixs.ad4.model.entity.Pedido;
import zenixs.ad4.service.ComercialService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comercial")
public class ComercialRestController {
	@Autowired
	private ComercialService comercialService;

	/**
	 * Maneja la petición GET /comercial/uno/{idComercial}
	 * Devuelve un comercial
	 * @param idComercial id del comercial
	 * @return Comercial
	 */
	@GetMapping("/uno/{idComercial}")
	public Comercial getComercial(@PathVariable int idComercial) {
		return comercialService.getComercial(idComercial);
	}

	/**
	 * Maneja la petición DELETE /comercial/eliminar/{idComercial}
	 * Elimina un comercial
	 * @param idComercial id del comercial
	 * @return boolean true si se ha eliminado, false si no
	 */
	@DeleteMapping("/eliminar/{idComercial}")
	public boolean deleteComercial(@PathVariable int idComercial) {
		return comercialService.deleteComercial(idComercial);
	}

	/**
	 * Maneja la petición POST /comercial/alta
	 * Da de alta un comercial
	 * @param comercial Comercial a dar de alta
	 * @return Comercial dado de alta
	 */
	@PostMapping("/alta")
	public Comercial altaComercial(@RequestBody Comercial comercial) {
		return comercialService.altaComercial(comercial);
	}
		
	/**
	 * Maneja la petición GET /comercial/bycliente/{idCliente}
	 * Devuelve los comerciales que han realizado pedidos con un cliente
	 * @param idCliente id del cliente
	 * @return List<Comercial> lista de comerciales que han realizado pedidos con el cliente
	 */
	@GetMapping("/bycliente/{idCliente}")
	public List<Comercial> getComercialesPorCliente(@PathVariable int idCliente) {
		return comercialService.getComercialesPorCliente(idCliente); 
	}

	/**
	 * Maneja la petición GET /comercial/conpedidos
	 * Devuelve los comerciales que han realizado pedidos
	 * @return List<Comercial> lista de comerciales que han realizado pedidos
	 */
	@GetMapping("/conpedidos")
	public List<Comercial> getComercialesConPedidos() {
		return comercialService.getComercialesConPedidos();
	}

}
