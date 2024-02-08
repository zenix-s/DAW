package zenixs.eventos.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zenixs.eventos.model.entity.Usuario;
import zenixs.eventos.model.repository.UsuarioRepository;

@Repository
public class ImplementUsuarioDao implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRep;

	@Override
	public Usuario registerUsuario(Usuario usuario) {

		if (usuario == null)
			return null;
		try {
			return usuarioRep.save(usuario);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Usuario findUsuarioById(String idUsuario) {

		if (idUsuario == null)
			return null;
		return usuarioRep.findById(idUsuario).orElse(null);
	}

}
