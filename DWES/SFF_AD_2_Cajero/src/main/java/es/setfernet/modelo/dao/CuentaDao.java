package es.setfernet.modelo.dao;

import java.util.List;

import es.setfernet.modelo.entitybean.Cuenta;

public interface CuentaDao {
	List<Cuenta> findAllCuenta();
	Cuenta findAcc (int idCuenta);
	int updateAcc (Cuenta cuenta);
}