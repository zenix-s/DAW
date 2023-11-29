package es.setfernet.modelo.entitybean;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="movimientos")
public class Movimiento
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_movimiento")
	private int  idMovimiento;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private double cantidad;
	private String operacion;
	
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

	public Movimiento(double cantidad, Cuenta cuenta, Date fecha, String operacion) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}
	
	
}