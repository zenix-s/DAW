package zenixs.eventos.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import zenixs.eventos.model.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	
}
