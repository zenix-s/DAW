package modelo.javabeans;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idCliente;
	private String nombre;
	private int cantidadEmpleados;
	private double facturacionAnual;
	
	public Cliente(int idCliente, String nombre, int cantidadEmpleados, double facturacionAnual) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.cantidadEmpleados = cantidadEmpleados;
		this.facturacionAnual = facturacionAnual; 
	}
	public Cliente(String nombre, int cantidadEmpleados, double facturacionAnual) {
		super();
		this.nombre = nombre;
		this.cantidadEmpleados = cantidadEmpleados;
		this.facturacionAnual = facturacionAnual; 
	}
	public Cliente() {
		super();
		
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}
	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
	public double getFacturacionAnual() {
		return facturacionAnual;
	}
	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", cantidadEmpleados=" + cantidadEmpleados
				+ ", facturacionAnual=" + facturacionAnual + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidadEmpleados, facturacionAnual, idCliente, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return cantidadEmpleados == other.cantidadEmpleados
				&& Double.doubleToLongBits(facturacionAnual) == Double.doubleToLongBits(other.facturacionAnual)
				&& idCliente == other.idCliente && Objects.equals(nombre, other.nombre);
	}
	
	
	// 
	
	public double radioFacturacion() {
		return facturacionAnual / cantidadEmpleados;
	}
}
