package com.setfernet.modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.setfernet.modelo.javabean.Evento;

@Repository
public class ImplementEventoDao implements EventoDao {
	
	private List<Evento> eventoList;
	
	@Autowired
	private TipoDao tipoDao;
	
	

	public ImplementEventoDao(TipoDao tipoDao) {
		this.tipoDao = tipoDao;
		eventoList = new ArrayList<>();
		cargarLista();
	}
	
	public void cargarLista() {
		eventoList.add(new Evento(1, "Conferencia de Tecnología", "Conferencia sobre las últimas tecnologías", new Date(), 120, "123 Calle Principal", "Activo", true, 500, 100, 50.0, tipoDao.findById(1)));
        eventoList.add(new Evento(2, "Taller de Desarrollo Web", "Aprende a desarrollar sitios web interactivos", new Date(), 90, "456 Calle Secundaria", "Activo", false, 200, 50, 30.0, tipoDao.findById(2)));
        eventoList.add(new Evento(3, "Seminario de Marketing Digital", "Seminario sobre estrategias de marketing digital", new Date(), 150, "101 Calle Terciaria", "Activo", true, 400, 120, 60.0, tipoDao.findById(3)));
        eventoList.add(new Evento(4, "Presentación de Arte Contemporáneo", "Presentación pública de obras de arte contemporáneo", new Date(), 75, "303 Calle Cuarta", "Activo", true, 150, 40, 20.0, tipoDao.findById(4)));
        eventoList.add(new Evento(5, "Conferencia de Ciencias", "Conferencia sobre diversos campos de la ciencia", new Date(), 120, "789 Calle Quinta", "Activo", true, 300, 80, 40.0, tipoDao.findById(1)));
        eventoList.add(new Evento(6, "Taller de Fotografía", "Taller práctico para mejorar habilidades fotográficas", new Date(), 90, "202 Calle Sexta", "Activo", true, 200, 60, 35.0, tipoDao.findById(2)));
        eventoList.add(new Evento(7, "Seminario de Salud Mental", "Seminario sobre cuidado y salud mental", new Date(), 150, "404 Calle Séptima", "Activo", true, 400, 100, 55.0, tipoDao.findById(3)));
        eventoList.add(new Evento(8, "Presentación de Música Clásica", "Presentación de música clásica en vivo", new Date(), 75, "606 Calle Octava", "Activo", true, 150, 30, 15.0, tipoDao.findById(4)));
        eventoList.add(new Evento(9, "Conferencia de Historia", "Conferencia sobre eventos históricos importantes", new Date(), 120, "707 Calle Novena", "Activo", true, 300, 70, 35.0, tipoDao.findById(1)));
        eventoList.add(new Evento(10, "Taller de Cocina", "Taller práctico para aprender nuevas recetas de cocina", new Date(), 90, "909 Calle Décima", "Activo", true, 200, 50, 25.0, tipoDao.findById(2)));
	}
	

	@Override
	public Evento findById(int idEvento) {
		for (int i = 0; i < eventoList.size();i++) { 
			 if (eventoList.get(i).getIdEvento() == idEvento) return eventoList.get(i); 
		}
		
		return null;
	}

	@Override
	public List<Evento> findAll() {
		return eventoList;
	}
	
	@Override
	public int deleteEvento(int idEvento) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
