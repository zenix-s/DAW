package es.setfernet.modelo.dao;

import java.util.List;

import es.setfernet.modelo.entitybean.Movimiento;

public interface MovimientoDao {
	/**
	 * Se encarga de consultar a la bbdd todos los movimientos relacionados con una cuenta
	 * @param idCuenta id de la cuenta cuyos movimientos quiren localizarse
	 * @return retornara una lista de movimientos cuyo idCuenta sea el proporcionado
	 */
	List<Movimiento> findAllMovById(int idCuenta);
	
	/**
	 * Se encarga de insertar un nuevo movimiento a la bbdd
	 * @param	movimiento objeto clase Movimiento cuyos datos queremos insertar a la bbdd
	 * @return	Retorna el movimiento insertado en la base de datos
	 */
	Movimiento insertMov (Movimiento movimiento);
}
