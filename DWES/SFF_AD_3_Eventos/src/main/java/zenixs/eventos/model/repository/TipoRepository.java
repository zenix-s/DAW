package zenixs.eventos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zenixs.eventos.model.entity.Tipo;

/**
 * Repositorio de acceso a datos para la entidad Tipo.
 * Se extiende de JpaRepository para heredar el CRUD de la entidad.
 */
public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
