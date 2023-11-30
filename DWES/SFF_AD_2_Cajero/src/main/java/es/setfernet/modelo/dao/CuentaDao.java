package es.setfernet.modelo.dao;

import java.util.List;

import es.setfernet.modelo.entitybean.Cuenta;

public interface CuentaDao {
	/**
	 * Se encarga de devolver una lista con todas las cuentas que se encuentran en la BBDD
	 * @return Lista de cuentas
	 */
	List<Cuenta> findAllCuenta();
	
	/**
	 * Busca y encuentra una cuenta basado en un id proporcionado
	 * @param idCuenta id de la cuenta a devolver
	 * @return	Devolvera la cuenta en caso de encontrarla en caso contrario devolvera null si no encuetra la cuenta
	 */
	Cuenta findAcc (int idCuenta);
	
	/**
	 * permite actualizar los datos de una cuenta
	 * @param cuenta objeto cuenta con los datos actualizados.
	 * @return devolvera 1 si se ha actualizado la cuenta con exito
	 */
	int updateAcc (Cuenta cuenta);
}