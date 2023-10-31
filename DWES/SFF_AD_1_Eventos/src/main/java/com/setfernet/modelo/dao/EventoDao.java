package com.setfernet.modelo.dao;

import com.setfernet.modelo.javabean.Evento;
import java.util.List;

public interface EventoDao {
	/**
	 * Esto es una función que busca un evento en función de un id
	 * @param idEvento
	 * @return
	 */
	Evento findById(int idEvento);
	/**
	 * 
	 * @return
	 */
	List<Evento> findAllActive();
	List<Evento> findAllNoActive();
	List<Evento> findAll();
	boolean deleteEvent(int idEvento);
	boolean newEvent(Evento evento);
	boolean cancelEvent(int idEvento);
	boolean updateEvent(Evento evento);
	
}
