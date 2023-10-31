package com.setfernet.modelo.dao;

import java.util.List;

import com.setfernet.modelo.javabean.Tipo;

public interface TipoDao {
	List<Tipo> findAll();
	Tipo findById(int idTipo);
}
