package zenixs.ad4.service;

import java.util.List;
import zenixs.ad4.model.entity.Comercial;

public interface ComercialService {

	Comercial altaComercial(Comercial comercial);

	Comercial getComercial(int id);

	boolean deleteComercial(int id);

	List<Comercial> getComercialesPorCliente(int idCliente);

	List<Comercial> getComercialesConPedidos();


}
