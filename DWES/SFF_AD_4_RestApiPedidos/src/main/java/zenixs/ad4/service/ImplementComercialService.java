package zenixs.ad4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zenixs.ad4.model.entity.Comercial;
import zenixs.ad4.model.entity.Pedido;
import zenixs.ad4.repository.ComercialRepository;

@Service
public class ImplementComercialService implements ComercialService {

	@Autowired
	private ComercialRepository comercialRepository;

	@Override
	public Comercial altaComercial(Comercial comercial) {
		if (comercial == null)
			return null;
		try {
			return comercialRepository.save(comercial);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Comercial getComercial(int id) {
		return comercialRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteComercial(int id) {
		if (getComercial(id) == null)
			return false;
		try {
			comercialRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Comercial> getComercialesPorCliente(int idCliente) {
		return comercialRepository.getComercialesPorCliente(idCliente);
	}

	@Override
	public List<Comercial> getComercialesConPedidos() {
		return comercialRepository.getComercialesConPedidos();
	}

	@Override
	public List<Pedido> getPedidosComercial(int idComercial) {
		return comercialRepository.getPedidosComercial(idComercial);
	}

}
