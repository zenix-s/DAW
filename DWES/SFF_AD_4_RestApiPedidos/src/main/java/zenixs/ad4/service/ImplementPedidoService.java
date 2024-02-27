package zenixs.ad4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zenixs.ad4.model.entity.Pedido;
import zenixs.ad4.repository.PedidoRepository;

@Service
public class ImplementPedidoService implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> getPedidosComercial(int idComercial) {
		return pedidoRepository.getPedidosComercial(idComercial);
	}
}