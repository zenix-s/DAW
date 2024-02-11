package zenixs.eventos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zenixs.eventos.model.entity.Usuario;

/**
 * Repositorio de acceso a datos para la entidad Usuario.
 * Se extiende de JpaRepository para heredar el CRUD de la entidad.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
