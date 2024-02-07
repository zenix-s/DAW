package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Evento;

public interface EventoDao {

	List<Evento> findAllEvento();
	List<Evento> findAllMainEvento();
	List<Evento> findAllDestacadoEvento();
	List<Evento> findAllActiveEvento();
	Evento findEventoById(int idEvento);
	Evento insertEvento(Evento evento);
	int updateEvento(Evento evento);
	int deleteEvento(Evento evento);
}
