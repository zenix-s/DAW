package com.setfernet.model.dao;

import java.util.List;

import com.setfernet.model.entity.Comercial;

public interface ComercialDao {
	List<Comercial> findAll();
	Comercial findComercial(int idComercial);
	Comercial createComercial(Comercial comercial);
	int updateComercial(Comercial comercial);
	int delteComercial(int idComercial);
}
