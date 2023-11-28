package es.setfernet.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.setfernet.modelo.entitybean.Cuenta;
import es.setfernet.repository.CuentaRepository;

@Repository
public class ImplementCuentaDao implements CuentaDao{

	@Autowired
	private CuentaRepository crep;
	
	@Override
	public List<Cuenta> findAllCuenta() {
	    return crep.findAll();
	}

	@Override
	public Cuenta findAcc(int idCuenta) {
		return crep.findById(idCuenta).orElse(null);
	}



	@Override
	public int updateAcc(Cuenta cuenta) {
		try {
			crep.save(cuenta);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}


}
