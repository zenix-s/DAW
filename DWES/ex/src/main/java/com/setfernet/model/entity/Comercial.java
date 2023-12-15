package com.setfernet.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="comerciales")
public class Comercial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comercial")
	private int idComercial;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private double comision;
	public Comercial(int idComercial, String nombre, String apellido1, String apellido2, int comision) {
		super();
		this.idComercial = idComercial;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.comision = comision;
	}
	public Comercial() {
		super();
	}
	public int getIdComercial() {
		return idComercial;
	}
	public void setIdComercial(int idComercial) {
		this.idComercial = idComercial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idComercial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comercial other = (Comercial) obj;
		return idComercial == other.idComercial;
	}
	
	
}
