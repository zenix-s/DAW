package es.setfernet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.setfernet.modelo.entitybean.Cuenta;
import es.setfernet.modelo.entitybean.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{
	@Query("SELECT m FROM Movimiento m WHERE m.cuenta.idCuenta = ?1")
	public List<Movimiento> findAllMovByIdCuenta(int idCuenta);

}
