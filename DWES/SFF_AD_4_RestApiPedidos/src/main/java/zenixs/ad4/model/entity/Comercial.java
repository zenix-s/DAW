package zenixs.ad4.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un comercial
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "comerciales")
public class Comercial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comercial")
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private double comision;

	public Comercial(String nombre, String apellido1, String apellido2, double comision) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.comision = comision;
	}
}
