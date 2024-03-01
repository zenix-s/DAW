package zenixs.ad4.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import zenixs.ad4.model.entity.Pedido;
import zenixs.ad4.service.PedidoService;

@RestController
@CrossOrigin(origins = "*")
public class PedidoRestController {
	
	@Autowired
	private PedidoService pedidoService;

	/**
	 * Maneja la petición GET /comercial/pedidos/{idComercial}
	 * Devuelve los pedidos de un comercial
	 * @param idComercial id del comercial
	 * @return List<Pedido>
	 */
	// @GetMapping("/comercial/pedidos/{idComercial}")
	// public List<Pedido> getPedidosComercial(@PathVariable int idComercial) {
	// 	return pedidoService.getPedidosComercial(idComercial);
	// }
	@GetMapping("/comercial/pedidos/{idComercial}")
	public ResponseEntity<List<Pedido>> getPedidosComercial(@PathVariable int idComercial) {
		List<Pedido> pedidos = pedidoService.getPedidosComercial(idComercial);
		if (pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(200).body(pedidos);
	}
}
