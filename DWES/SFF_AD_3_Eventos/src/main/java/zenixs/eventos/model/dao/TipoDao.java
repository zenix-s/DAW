package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Tipo;

public interface TipoDao {
	/**
	 * Listar todos los tipos
	 * 
	 * @return lista de tipos
	 */
	List<Tipo> findAllTipo();

	/**
	 * Buscar un tipo por su id
	 * 
	 * @param idTipo
	 * @return tipo
	 */
	Tipo findTipoById(int idTipo);
}
