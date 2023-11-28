package es.setfernet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.setfernet.modelo.entitybean.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
	@Query("select c from Cuenta c where c.saldo > ?1")
	public List<Cuenta> findSaldoMayor(double saldo);
	
}
