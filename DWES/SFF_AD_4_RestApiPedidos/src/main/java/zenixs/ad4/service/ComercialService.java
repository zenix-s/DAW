package zenixs.ad4.service;

import java.util.List;
import zenixs.ad4.model.entity.Comercial;

public interface ComercialService {

	/**
	 * Da de alta un comercial en la base de datos
	 * @param comercial Comercial a dar de alta
	 * @return Comercial dado de alta
	 */
	Comercial altaComercial(Comercial comercial);

	/**
	 * Devuelve un comercial de la base de datos
	 * @param id id del comercial
	 * @return Comercial
	 */
	Comercial getComercial(int id);

	/**
	 * Elimina un comercial de la base de datos
	 * @param id id del comercial
	 * @return boolean true si se ha eliminado, false si no
	 */
	boolean deleteComercial(int id);

	/**
	 * Devuelve una lista de comerciales de la base de datos que tienen un pedido con un cliente concreto
	 * @return List<Comercial> lista de comerciales que han realizado pedidos con el cliente
	 */
	List<Comercial> getComercialesPorCliente(int idCliente);

	/**
	 * Devuelve una lista de comerciales de la base de datos que tienen al menos un pedido
	 * @return List<Comercial> lista de comerciales que han realizado pedidos
	 */
	List<Comercial> getComercialesConPedidos();


}
