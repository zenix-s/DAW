package zenixs.eventos.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zenixs.eventos.model.entity.Evento;
import zenixs.eventos.model.repository.EventoRepository;

@Repository
public class ImplementEventoDao implements EventoDao {
	@Autowired
	private EventoRepository eventoRep;

	@Override
	public List<Evento> findAllEvento() {
		return eventoRep.findAll();
	}

	@Override
	public List<Evento> findAllMainEvento() {
		return eventoRep.findAllEvento();
	}

	@Override
	public List<Evento> findAllDestacadoEvento() {
		return eventoRep.findAllDestacado();
	}

	@Override
	public List<Evento> findAllActiveEvento() {
		return eventoRep.findAllActive();
	}

	@Override
	public Evento findEventoById(int idEvento) {
		return eventoRep.findById(idEvento).orElse(null);
	}

	@Override
	public Evento insertEvento(Evento evento) {
		try {
			return eventoRep.save(evento);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}

	@Override
	public int updateEvento(Evento evento) {
		try {
			eventoRep.save(evento);
			return 1;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int deleteEvento(Evento evento) {
		
		try {
			eventoRep.delete(evento);
			return 1;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return 0;
		}
	}
}