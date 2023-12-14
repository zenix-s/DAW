package com.setfernet.model.dao;

import java.util.List;

import com.setfernet.model.entity.Comercial;

public interface ComercialDao {
	List<Comercial> findAll();
	Comercial findComercial();
	Comercial createComercial();
	int updateComercial();
	int delteComercial();
}
