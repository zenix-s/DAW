package zenixs.eventos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zenixs.eventos.model.entity.Perfil;

/**
 * Repositorio de acceso a datos para la entidad Perfil.
 * Se extiende de JpaRepository para heredar el CRUD de la entidad.
 */
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
