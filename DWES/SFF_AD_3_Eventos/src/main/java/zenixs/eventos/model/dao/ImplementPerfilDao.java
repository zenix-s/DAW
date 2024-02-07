package zenixs.eventos.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zenixs.eventos.model.entity.Perfil;
import zenixs.eventos.model.repository.PerfilRepository;

@Repository
public class ImplementPerfilDao implements PerfilDao{
	
	@Autowired
	private PerfilRepository perfilRep;

	@Override
	public List<Perfil> findAllPerfil() {
		return perfilRep.findAll();
	}

	@Override
	public Perfil findPerfilById(int idPerfil) {
		return perfilRep.findById(idPerfil).orElse(null);
	}
}
