package zenixs.eventos.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * Clase de persistencia para la tabla "TIPOS".
 * 
 */
@Entity
@Table(name = "TIPOS")
@NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO")
	private int idTipo;

	private String descripcion;

	private String nombre;

	public Tipo() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
	}

}