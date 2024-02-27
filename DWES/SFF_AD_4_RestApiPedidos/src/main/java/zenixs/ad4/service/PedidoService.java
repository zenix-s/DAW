package zenixs.ad4.service;

import java.util.List;

import zenixs.ad4.model.entity.Pedido;

public interface PedidoService {

	List<Pedido> getPedidosComercial(int idComercial);
	
}