package com.setfernet.modelo.dao;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.setfernet.modelo.javabean.Tipo;

@Repository
public class ImplementTipoDao implements TipoDao  {
	private List<Tipo> tipoList;
	
	
	
	
	public ImplementTipoDao() {
		tipoList = new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {
		tipoList.add(new Tipo(1, "Conferencia", "Conferencia sobre temas diversos"));
        tipoList.add(new Tipo(2, "Taller", "Sesión interactiva para aprender habilidades específicas"));
        tipoList.add(new Tipo(3, "Seminario", "Seminario educativo sobre un tema específico"));
        tipoList.add(new Tipo(4, "Presentación", "Presentación pública sobre un tema de interés"));
	}
	
	@Override
	public List<Tipo> findAll() {
		return tipoList;
	}
	@Override
	public Tipo findById(int idTipo) {
		
		 for (int i = 0; i < tipoList.size();i++) { 
			 if (tipoList.get(i).getIdTipo() == idTipo) return tipoList.get(i); 
		 }
		 
		return null;
	}
}
