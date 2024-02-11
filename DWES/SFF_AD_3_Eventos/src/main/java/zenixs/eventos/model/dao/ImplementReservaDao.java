package zenixs.eventos.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zenixs.eventos.model.entity.Reserva;
import zenixs.eventos.model.repository.ReservaRepository;

@Repository
public class ImplementReservaDao  implements ReservaDao {

	@Autowired
	private ReservaRepository reservaRep;

	@Override
	public List<Reserva> findAllReservaByIdEvento(Integer idEvento) {
		return reservaRep.findAllByIdEvento(idEvento);
	}

	@Override
	public List<Reserva> findAllReservaByIdUsuario(String idUsuario) {
		return reservaRep.findAllByIdUsuario(idUsuario);
	}

	@Override
	public List<Reserva> findAllReservaByIdUsuarioAndFechaInicio(String idUsuario) {
		return reservaRep.findAllReservaByIdUsuarioAndCurrentDate(idUsuario);
	}

	@Override
	public Reserva findReservaById(Integer idReserva) {
		return reservaRep.findById(idReserva).orElse(null);
	}

	@Override
	public Integer sumCantidadByIdEvento(Integer idEvento) {
		return reservaRep.sumCantidadByIdEvento(idEvento);
	}

	@Override
	public Integer sumCantidadByIdEventoAndIdUsuario(Integer idEvento, String idUsuario) {
		return reservaRep.sumCantidadByIdEventoAndIdUsuario(idEvento, idUsuario);
	}

	@Override
	public Integer insertReserva(Reserva reserva) {
		try {
			reservaRep.save(reserva);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Integer deleteReserva(Integer idReserva) {
		try {
			reservaRep.deleteById(idReserva);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
