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
@Table(name="inventario")
@Data
@NoArgsConstructor
public class InventarioEntity {

	@Id
	@Column(name="id")
	private int id;
	
	//private ProductoEntity producto;
	@Column(name = "cantidad", nullable = false, scale = 0)
	private int cantidad;
	@Column(name="fecha_ingreso_lote", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaDeIngresoLote;
	@Column(name="fecha_vencimiento_lote", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaVencimientoLote;
	
}
