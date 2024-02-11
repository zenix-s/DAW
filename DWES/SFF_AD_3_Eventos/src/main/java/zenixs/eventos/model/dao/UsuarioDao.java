package zenixs.eventos.model.dao;

import zenixs.eventos.model.entity.Usuario;

public interface UsuarioDao {
	/**
	 * Buscar un usuario por su id
	 * 
	 * @param usuario id del usuario a buscar
	 * @return usuario
	 */
	Usuario registerUsuario(Usuario usuario);

	/**
	 * Buscar un usuario por su id
	 * 
	 * @param idUsuario id del usuario a buscar
	 * @return usuario
	 */
	Usuario findUsuarioById(String idUsuario);
}
