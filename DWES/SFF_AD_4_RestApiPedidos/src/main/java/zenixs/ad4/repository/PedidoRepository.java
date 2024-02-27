package zenixs.ad4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zenixs.ad4.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	/**
	 * Devuelve los pedidos de un comercial
	 * 
	 * @param idComercial id del comercial
	 * @return List<Pedido> lista de pedidos
	 */
	@Query("SELECT p FROM Pedido p WHERE p.comercial.id = ?1")
	public List<Pedido> getPedidosComercial(int idComercial);

}
