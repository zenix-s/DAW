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
 * Clase que representa un cliente
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciudad;
	private Integer categoria;
}
