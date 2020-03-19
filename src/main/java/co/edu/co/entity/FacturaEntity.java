package co.edu.co.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="factura")
@Data
@NoArgsConstructor
public class FacturaEntity {
	
	@Id
	@Column(name="id")
	private Long idFactura;
	@Column(name="fecha_venta", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaVenta;
	
	//private List<DetalleFacturaEntity> productosYCantidades;
	
	@Column(name = "valor_total", nullable = false, scale = 2)
	private double valorTotal;
	
	/*
	 * @JoinColumn(name="id_cliente", nullable = false) private ClienteEntity
	 * cliente;
	 * 
	 * @JoinColumn(name="id_empleado", nullable = false) private EmpleadoEntity
	 * empleado;
	 */

}
