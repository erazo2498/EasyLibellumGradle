package co.edu.co.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="empleado")
@Data
@NoArgsConstructor
public class EmpleadoEntity {
	
	@Id
	@Column(name="id")
	private String identificacion;
	@Column(name="usuario", nullable=false, length=30)
	private String usuario;
	@Column(name="contrasena", nullable=false, length=30)
	private String contrasena;
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	@Column(name="apellido", nullable=false, length=50)
	private String apellido;
	
	private String rol;
	@Column(name="telefono", nullable=false, length=20)
	private String telefono;
	@Column(name = "sueldo", nullable = false, scale = 2)
	private double sueldo;
	@Column(name="fecha_ingreso", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	@Column(name="fecha_nacimiento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UbicacionEntity ubicacion;

}
