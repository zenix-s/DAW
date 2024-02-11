package zenixs.eventos.model.dao;

import java.util.List;

import zenixs.eventos.model.entity.Reserva;

public interface ReservaDao {

	/**
	 * Listar todas las reservas
	 * @param idEvento id del evento con reservas a listar
	 * @return lista de reservas
	 */
	List<Reserva> findAllReservaByIdEvento(Integer idEvento);

	/**
	 * Listar todas las reservas
	 * @param idUsuario id del usuario con reservas a listar
	 * @return	lista de reservas
	 */
	List<Reserva> findAllReservaByIdUsuario(String idUsuario);

	/**
	 * Listar todas las reservas por un id de usuario y fecha de inicio mayor a la actual
	 * @param idUsuario id del usuario con reservas a listar
	 * @return lista de reservas
	 */
	List<Reserva> findAllReservaByIdUsuarioAndFechaInicio(String idUsuario);

	/**
	 * Sumar la cantidad de reservas por un id de evento
	 * @param idEvento id del evento con reservas a sumar
	 * @return cantidad de reservas
	 */
	Integer sumCantidadByIdEvento(Integer idEvento);

	/**
	 * Sumar la cantidad de reservas por un id de evento y un id de usuario
	 * @param idEvento id del evento con reservas a sumar
	 * @param idUsuario id del usuario con reservas a sumar
	 * @return cantidad de reservas
	 */
	Integer sumCantidadByIdEventoAndIdUsuario(Integer idEvento, String idUsuario);

	/**
	 * Buscar una reserva por su id
	 * @param idReserva id de la reserva a buscar
	 * @return reserva
	 */
	Reserva findReservaById(Integer idReserva);

	/**
	 * Insertar una reserva en la base de datos
	 * @param reserva reserva a insertar
	 * @return reserva
	 */
	Integer insertReserva(Reserva reserva);

	/**
	 * Actualizar una reserva en la base de datos
	 * @param idReserva id de la reserva a actualizar
	 * @return reserva
	 */
	Integer deleteReserva(Integer idReserva);

}
