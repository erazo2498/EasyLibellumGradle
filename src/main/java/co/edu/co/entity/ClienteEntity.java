package co.edu.co.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cliente")
@Data
@NoArgsConstructor
public class ClienteEntity {
	
	@Id
	@Column(name="id")
	private String identificacion;
	
	@Column(name="nombre", nullable=false, length=30)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=50)
	private String apellido;
	
	@Column(name="telefono", nullable=false, length=15)
	private String telefono;
	
	@Column(name="fecha_nacimiento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UbicacionEntity ubicacion;

}
