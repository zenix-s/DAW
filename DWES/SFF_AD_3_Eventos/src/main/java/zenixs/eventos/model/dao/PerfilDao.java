package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Perfil;

public interface PerfilDao {

	/**
	 * Listar todos los perfiles
	 * 
	 * @return lista de perfiles
	 */
	List<Perfil> findAllPerfil();

	/**
	 * Buscar un perfil por su id
	 * 
	 * @param idPerfil
	 * @return perfil
	 */
	Perfil findPerfilById(int idPerfil);
}
