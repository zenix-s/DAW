package zenixs.eventos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import zenixs.eventos.model.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
	
	@Query("SELECT e FROM Evento e WHERE e.estado = 'ACTIVO' AND e.destacado = 'S'")
	public List<Evento> findAllEvento();
	
	@Query("SELECT e FROM Evento e WHERE e.estado = 'ACTIVO'")
	public List<Evento> findAllActive();
	
	@Query("SELECT e FROM Evento e WHERE e.destacado = 'S'")
	public List<Evento> findAllDestacado();
}
