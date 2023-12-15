package com.setfernet.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.setfernet.model.entity.Comercial;
import com.setfernet.repository.ComercialRepository;

@Repository
public class ImplementComercialDao implements ComercialDao{

	@Autowired
	private ComercialRepository corep;
	
	@Override
	public List<Comercial> findAll() {
		return corep.findAll();
	}

	@Override
	public Comercial findComercial(int idComercial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comercial createComercial(Comercial comercial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateComercial(Comercial comercial) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delteComercial(int idComercial) {
		// TODO Auto-generated method stub
		return 0;
	}

}
