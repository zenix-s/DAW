package com.setfernet.modelo.javabean;

import java.util.Date;
import java.util.Objects;


public class Evento {
	
	private static final long serialVersionUID = 1L;
	
	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private boolean destacado;
	private int aforoMaximo;
	private int asistenciaMinima;
	private double precio;
	private Tipo tipo;
	
	public Evento(int idEvento, String nombre, String descripcion, Date fechaInicio, int duracion, String direccion,
			String estado, boolean destacado, int aforoMaximo, int asistenciaMinima, double precio, Tipo tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMaximo = aforoMaximo;
		this.asistenciaMinima = asistenciaMinima;
		this.precio = precio;
		this.tipo = tipo;
	}
	

	public Evento(String nombre, String descripcion, Date fechaInicio, int duracion, String direccion, String estado,
			boolean destacado, int aforoMaximo, int asistenciaMinima, double precio, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMaximo = aforoMaximo;
		this.asistenciaMinima = asistenciaMinima;
		this.precio = precio;
		this.tipo = tipo;
	}

	

	public Evento(String nombre, String descripcion, Date fechaInicio, int duracion, String direccion, String estado,
			boolean destacado, int aforoMaximo, int asistenciaMinima, double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMaximo = aforoMaximo;
		this.asistenciaMinima = asistenciaMinima;
		this.precio = precio;
	}


	public Evento() {
		super();
	}


	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isDestacado() {
		return destacado;
	}

	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}

	public int getAforoMaximo() {
		return aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}

	public int getAsistenciaMinima() {
		return asistenciaMinima;
	}

	public void setAsistenciaMinima(int asistenciaMinima) {
		this.asistenciaMinima = asistenciaMinima;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", aforoMaximo=" + aforoMaximo + ", asistenciaMinima=" + asistenciaMinima
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}
	
	
	
	
}
