package zenixs.eventos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import zenixs.eventos.model.entity.Evento;

/**
 * Repositorio de acceso a datos para la entidad Evento.
 * Se extiende de JpaRepository para heredar el CRUD de la entidad.
 */
public interface EventoRepository extends JpaRepository<Evento, Integer> {

	/**
	 * Método que retorna todos los eventos activos y destacados.
	 * 
	 * @return List<Evento>
	 */
	@Query("SELECT e FROM Evento e WHERE e.estado = 'ACTIVO' AND e.destacado = 'S'")
	public List<Evento> findAllEvento();

	/**
	 * Método que retorna todos los eventos activos.
	 * 
	 * @return List<Evento>
	 */
	@Query("SELECT e FROM Evento e WHERE e.estado = 'ACTIVO'")
	public List<Evento> findAllActive();

	/**
	 * Método que retorna todos los eventos destacados.
	 * 
	 * @return List<Evento>
	 */
	@Query("SELECT e FROM Evento e WHERE e.destacado = 'S'")
	public List<Evento> findAllDestacado();
}
