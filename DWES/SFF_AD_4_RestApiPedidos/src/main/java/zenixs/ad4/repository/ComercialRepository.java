package zenixs.ad4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import zenixs.ad4.model.entity.Comercial;

/**
 * Repositorio de comerciales, extiende de JpaRepository
 * Encargado de gestionar las operaciones con la base de datos
 */
public interface ComercialRepository extends JpaRepository<Comercial, Integer> {

	/**
	 * Devuelve los comerciales que han realizado pedidos con un cliente
	 * @param idCliente id del cliente
	 * @return List<Comercial> lista de comerciales
	 */
	@Query("SELECT c FROM Comercial c WHERE (SELECT COUNT(p) FROM Pedido p WHERE p.comercial.id = c.id AND p.cliente.id = ?1) > 0")
	public List<Comercial> getComercialesPorCliente(int idCliente);

	/**
	 * Devuelve los comerciales que han realizado pedidos con al menos un cliente
	 * @return List<Comercial> lista de comerciales
	 */
	@Query("SELECT c FROM Comercial c WHERE (SELECT COUNT(p) FROM Pedido p WHERE p.comercial.id = c.id) > 0")
	public List<Comercial> getComercialesConPedidos();

}
