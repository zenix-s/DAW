package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Perfil;

public interface PerfilDao {
	List<Perfil> findAllPerfil();
	Perfil findPerfilById(int idPerfil);
}
