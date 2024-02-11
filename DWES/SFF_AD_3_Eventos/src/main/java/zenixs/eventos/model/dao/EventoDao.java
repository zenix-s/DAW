package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Evento;

public interface EventoDao {

	/**
	 * Listar todos los eventos
	 * 
	 * @return lista de eventos
	 */
	List<Evento> findAllEvento();

	/**
	 * Listar todos los eventos con atributo destacado y activo
	 * 
	 * @return lista de eventos
	 */
	List<Evento> findAllMainEvento();

	/**
	 * Listar todos los eventos con atributo destacado
	 * 
	 * @return lista de eventos
	 */
	List<Evento> findAllDestacadoEvento();

	/**
	 * Listar todos los eventos con atributo activo
	 * 
	 * @return lista de eventos
	 */
	List<Evento> findAllActiveEvento();

	/**
	 * Buscar un evento por su id
	 * 
	 * @param idEvento
	 * @return evento
	 */
	Evento findEventoById(int idEvento);

	/**
	 * Insertar un evento en la base de datos
	 * 
	 * @param evento
	 * @return evento
	 */
	Evento insertEvento(Evento evento);

	/**
	 * Actualizar un evento en la base de datos
	 * 
	 * @param evento
	 * @return evento
	 */
	int updateEvento(Evento evento);

	/**
	 * Eliminar un evento de la base de datos
	 * 
	 * @param evento
	 * @return evento
	 */
	int deleteEvento(Evento evento);
}
