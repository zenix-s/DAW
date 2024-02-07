package zenixs.eventos.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zenixs.eventos.model.entity.Tipo;
import zenixs.eventos.model.repository.TipoRepository;

@Repository
public class ImplementTipoDao implements TipoDao {

	@Autowired
	private TipoRepository tipoRep;

	@Override
	public List<Tipo> findAllTipo() {

		return tipoRep.findAll();

	}

	@Override
	public Tipo findTipoById(int idTipo) {
		return tipoRep.findById(idTipo).orElse(null);
	}

}
