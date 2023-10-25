package com.setfernet.modelo.dao;

import com.setfernet.modelo.javabean.Evento;
import java.util.List;

public interface EventoDao {
	Evento findById(int idEvento);
	List<Evento> findAll();
	int deleteEvento(int idEvento);
	
}
