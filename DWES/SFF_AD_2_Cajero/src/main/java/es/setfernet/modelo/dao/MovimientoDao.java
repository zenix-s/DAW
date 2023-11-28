package es.setfernet.modelo.dao;

import java.util.List;

import es.setfernet.modelo.entitybean.Movimiento;

public interface MovimientoDao {
	List<Movimiento> findAllMov();
	List<Movimiento> findAllMovById(int idCuenta);
	Movimiento findMov (int idMovimiento);
	Movimiento insertMov (Movimiento movimiento);
	int updateMov (Movimiento movimiento);
	int deleteMov (int idMovimiento);
}
