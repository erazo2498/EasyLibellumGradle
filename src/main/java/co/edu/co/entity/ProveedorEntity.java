package co.edu.co.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="proveedor")
@Data
@NoArgsConstructor
public class ProveedorEntity {
	
	@Id
	@Column(name="id")
	private String nit;
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	@Column(name="telefono", nullable=false, length=20)
	private String telefono;
	
	//private List<ProductoEntity> productos;
	@OneToOne(cascade = CascadeType.ALL)
	private UbicacionEntity ubicacion;
}
