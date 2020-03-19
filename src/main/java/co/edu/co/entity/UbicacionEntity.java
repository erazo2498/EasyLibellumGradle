package co.edu.co.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "ubicacion")
@Data
@NoArgsConstructor
public class UbicacionEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="ciudad", nullable=false, length=30)
	private String ciudad;
	
	@Column(name="departamento", nullable=false, length=30)
	private String departamento;
	
	@Column(name="direccion", nullable=false, length=50)
	private String direccion;

	@OneToOne
	@JoinColumn(name="id", nullable=false)
	private ClienteEntity cliente;
	
	@OneToOne()
	@JoinColumn(name="id", nullable=false)
	private EmpleadoEntity empleado;
	
	@OneToOne
	@JoinColumn(name="id", nullable=false)
	private ProveedorEntity proveedor;
}
