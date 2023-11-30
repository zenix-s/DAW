package es.setfernet.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.setfernet.modelo.entitybean.Movimiento;
import es.setfernet.repository.MovimientoRepository;

@Repository
public class ImplementMovimientoDao implements MovimientoDao{
	@Autowired
	private MovimientoRepository movrep;

	
	
	@Override
	public List<Movimiento> findAllMovById(int idCuenta)
	{
		return movrep.findAllMovByIdCuenta(idCuenta);
	}

	

	@Override
	public Movimiento insertMov(Movimiento movimiento) {
		try {			
			return movrep.save(movimiento);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
