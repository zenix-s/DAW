package zenixs.eventos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zenixs.eventos.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
		
}
