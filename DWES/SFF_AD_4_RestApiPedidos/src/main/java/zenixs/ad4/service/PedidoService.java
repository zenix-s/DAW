package zenixs.ad4.service;

import java.util.List;

import zenixs.ad4.model.entity.Pedido;

public interface PedidoService {

	/**
	 * Lista de pedidos manejada por un comercial concreto
	 * @param idComercial id del comercial
	 * @return List<Pedido> lista de pedidos
	 */
	List<Pedido> getPedidosComercial(int idComercial);
	
}