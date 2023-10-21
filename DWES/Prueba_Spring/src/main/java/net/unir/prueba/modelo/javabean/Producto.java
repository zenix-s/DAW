package net.unir.prueba.modelo.javabean;

import java.util.Date;
import java.util.Objects;

public class Producto {
	private int id;
	private String nombre;
	private String tipoProducto;
	private String talla;
	private int inventario;
	private double precio;
	private Date fechaAlta;
	private String descripción;
	
	public Producto() {
		super();
	}

	public Producto(int id, String nombre, String tipoProducto, String talla, int inventario, double precio,
			Date fechaAlta, String descripción) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoProducto = tipoProducto;
		this.talla = talla;
		this.inventario = inventario;
		this.precio = precio;
		this.fechaAlta = fechaAlta;
		this.descripción = descripción;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaAlta, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(fechaAlta, other.fechaAlta) && id == other.id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", tipoProducto=" + tipoProducto + ", talla=" + talla
				+ ", inventario=" + inventario + ", precio=" + precio + ", fechaAlta=" + fechaAlta + ", descripción="
				+ descripción + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	
	
	
}
