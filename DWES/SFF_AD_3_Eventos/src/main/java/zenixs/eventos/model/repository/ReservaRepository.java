package zenixs.eventos.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zenixs.eventos.model.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Query("SELECT r FROM Reserva r WHERE r.idEvento = ?1")
	List<Reserva> findByIdEvento(Integer idEvento);

	// int sum of cantidad from Reserva where idEvento = ?1
	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.idEvento = ?1")
	Integer sumCantidadByIdEvento(Integer idEvento);
}