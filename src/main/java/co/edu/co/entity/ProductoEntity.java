package co.edu.co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="producto")
@Data
@NoArgsConstructor
public class ProductoEntity {

	@Id
	@Column(name="id")
	private int codigoBarras;
	@Column(name="nombre", nullable=false, length=30)
	private String nombre;
	@Column(name="marca", nullable=false, length=30)
	private String marca;
	@Column(name = "iva", nullable = false, scale = 2)
	private double iva;
	@Column(name = "precio_compra", nullable = false, scale = 2)
	private double precioCompra;
	@Column(name = "precio_venta", nullable = false, scale = 2)
	private double precioVenta;
	
}
