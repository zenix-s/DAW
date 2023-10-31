package com.setfernet.modelo.javabean;

import java.util.Objects;

public class Tipo {
	
	private static final long serialVersionUID = 1L;
	
	private int idTipo;
	private String nombre;
	private String descripcion;
	
	public Tipo(int idTipo, String nombre, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Tipos [idTipo=" + idTipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		return idTipo == other.idTipo;
	}
	
	
	
	
	
}
