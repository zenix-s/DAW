package zenixs.eventos.model.dao;

import zenixs.eventos.model.entity.Usuario;

public interface UsuarioDao {
	
	Usuario registerUsuario(Usuario usuario);
	Usuario findUsuarioById(String idUsuario);
}
