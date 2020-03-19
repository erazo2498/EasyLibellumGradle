package co.edu.co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="detalle_factura")
@Data
@NoArgsConstructor
public class DetalleFacturaEntity {
	
	@Id
	@Column(name="id")
	private Long id; 
	
	@Column(name = "id_factura", nullable = false, scale = 0)
	private Long idFactura;
	
	@Column(name = "cantidad_producto", nullable = false, scale = 0)
	private int cantidadProducto;
	
	//private ProductoEntity producto;

}
