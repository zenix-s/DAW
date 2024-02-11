package zenixs.eventos.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zenixs.eventos.model.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Query("SELECT r FROM Reserva r WHERE r.evento.idEvento = ?1")
	List<Reserva> findAllByIdEvento(Integer idEvento);

	@Query("SELECT r FROM Reserva r WHERE r.usuario.username = ?1")
	List<Reserva> findAllByIdUsuario(String idUsuario);

	@Query("SELECT r FROM Reserva r WHERE r.usuario.username = ?1 AND r.evento.fechaInicio > CURRENT_DATE")
	List<Reserva> findAllReservaByIdUsuarioAndCurrentDate(String idUsuario);

	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.evento.idEvento = ?1")
	Integer sumCantidadByIdEvento(Integer idEvento);

	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.evento.idEvento = ?1 AND r.usuario.username = ?2")
	Integer sumCantidadByIdEventoAndIdUsuario(Integer idEvento, String idUsuario);
}