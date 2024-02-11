package zenixs.eventos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zenixs.eventos.model.entity.Reserva;

/**
 * Repositorio de acceso a datos para la entidad Reserva.
 * Se extiende de JpaRepository para heredar el CRUD de la entidad.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

	/**
	 * Método que retorna todas las reservas de un evento basado en su id.
	 * 
	 * @param idEvento Id del evento.
	 * @return List<Reserva>
	 */
	@Query("SELECT r FROM Reserva r WHERE r.evento.idEvento = ?1")
	List<Reserva> findAllByIdEvento(Integer idEvento);

	/**
	 * Método que retorna todas las reservas de un usuario basado en su id.
	 * 
	 * @param idUsuario Id del usuario.
	 * @return List<Reserva>
	 */
	@Query("SELECT r FROM Reserva r WHERE r.usuario.username = ?1")
	List<Reserva> findAllByIdUsuario(String idUsuario);

	/**
	 * Retorna todas las reservas de un usuario basado en su id y que la fecha del
	 * evento sea mayor a la fecha actual.
	 * 
	 * @param idUsuario Id del usuario.
	 * @return List<Reserva>
	 */
	@Query("SELECT r FROM Reserva r WHERE r.usuario.username = ?1 AND r.evento.fechaInicio > CURRENT_DATE")
	List<Reserva> findAllReservaByIdUsuarioAndCurrentDate(String idUsuario);

	/**
	 * Retorna la cantidad de reservas de un evento basado en su id.
	 * 
	 * @param idEvento Id del evento.
	 * @return Integer
	 */
	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.evento.idEvento = ?1")
	Integer sumCantidadByIdEvento(Integer idEvento);

	/**
	 * Retorna la cantidad de reservas de un evento basado en su id y el id del
	 * usuario.
	 * 
	 * @param idEvento  Id del evento.
	 * @param idUsuario Id del usuario.
	 * @return Integer
	 */
	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.evento.idEvento = ?1 AND r.usuario.username = ?2")
	Integer sumCantidadByIdEventoAndIdUsuario(Integer idEvento, String idUsuario);
}