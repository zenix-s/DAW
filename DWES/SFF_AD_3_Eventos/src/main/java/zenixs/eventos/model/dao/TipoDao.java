package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Tipo;

public interface TipoDao {
	List<Tipo> findAllTipo();
	Tipo findTipoById(int idTipo);
}
