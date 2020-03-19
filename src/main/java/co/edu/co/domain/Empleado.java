package co.edu.co.domain;

import java.util.Date;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import co.edu.co.util.UtilTexto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empleado {

	private String identificacion;
	private String usuario;
	private String contrasena;
	private String nombre;
	private String apellido;
	private String rol;
	private String telefono;
	private double sueldo;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Ubicacion ubicacion;

	public Empleado(String identificacion, String usuario, String contrasena, String nombre, String apellido,
			String rol,String telefono,double sueldo, Date fechaIngreso, Date fechaNacimiento,Ubicacion ubicacion) {
		super();
		this.identificacion = UtilObjeto.utilObjeto().evitarNulos(identificacion, "").trim();
		this.usuario = UtilObjeto.utilObjeto().evitarNulos(usuario, "").trim();
		this.contrasena = UtilObjeto.utilObjeto().evitarNulos(contrasena, "").trim();
		this.nombre = UtilObjeto.utilObjeto().evitarNulos(nombre, "").trim();
		this.apellido = UtilObjeto.utilObjeto().evitarNulos(apellido, "").trim();
		this.rol = UtilObjeto.utilObjeto().evitarNulos(rol, "").trim();
		this.telefono = UtilObjeto.utilObjeto().evitarNulos(telefono, "").trim();
		this.sueldo = sueldo;
		this.fechaIngreso = UtilObjeto.utilObjeto().evitarNulos(fechaIngreso, new Date());
		this.fechaNacimiento = UtilObjeto.utilObjeto().evitarNulos(fechaNacimiento, new Date());
		this.ubicacion = UtilObjeto.utilObjeto().evitarNulos(ubicacion, new Ubicacion());
	}

	private void validarStrings(String textoValidacion, String mensajeError) throws Excepcion {
		if (UtilTexto.obtenerUtilTexto().esVacioONull(textoValidacion)) {
			throw new Excepcion(mensajeError);
		}
	}

	public Empleado validarCreacionEmpleado (Empleado empleado) throws Excepcion {
		validarStrings(empleado.getIdentificacion(), "La identificacion no puede ser nula");
		validarStrings(empleado.getUsuario(), "El usuario no puede ser nulo o vacio");
		if (empleado.getContrasena() == null || empleado.getContrasena().isEmpty()
				|| empleado.getContrasena().length() <= 8) {
			throw new Excepcion("La contraseña no puede ser vacia y debe contener más de 8 caracteres");
		}
		validarStrings(empleado.getNombre(), "El nombre no puede ser vacio o nulo");
		validarStrings(empleado.getApellido(), "El apellido no puede ser vacio o nulo");
		validarStrings(empleado.getRol(), "El Rol debe existir y no puede estar vacio");

		if (empleado.getFechaNacimiento() == null || new Date().before(empleado.getFechaNacimiento())
				|| new Date().equals(empleado.getFechaNacimiento())) {
			throw new Excepcion("La fecha de nacimiento debe ser antes de la fecha actual");
		}

		if (empleado.getFechaIngreso() == null || new Date().before(empleado.getFechaIngreso())
				|| empleado.getFechaIngreso().before(empleado.getFechaNacimiento())) {
			throw new Excepcion("La fecha de ingreso no puede ser nula ni en el futuro, ni trabajar antes de haber nacido; jajaja");
		}

		if (empleado.getSueldo() <= 0) {
			throw new Excepcion("El sueldo no puede ser menor que cero");
		}
		if (empleado.getTelefono() == null || empleado.getTelefono().isEmpty()
				|| empleado.getTelefono().length() < 10) {
			throw new Excepcion("El telefono es necesario para contactar al Empleado y debe tener 10 caracteres");
		}
		empleado.getUbicacion().validarCreacionUbicacion(empleado.getUbicacion());
		return empleado;
	}

	public Empleado actualizarEmpleado(Empleado empleado, Empleado actualizacion) throws Excepcion {

		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(empleado.getUsuario(), actualizacion.getUsuario())) {
			empleado.setUsuario(actualizacion.getUsuario());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(empleado.getContrasena(), actualizacion.getContrasena())) {
			empleado.setContrasena(actualizacion.getContrasena());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(empleado.getNombre(), actualizacion.getNombre())) {
			empleado.setNombre(actualizacion.getNombre());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(empleado.getApellido(), actualizacion.getApellido())) {
			empleado.setApellido(actualizacion.getApellido());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(empleado.getRol(), actualizacion.getRol())) {
			empleado.setRol(actualizacion.getRol());
		}
		if (actualizacion.getFechaIngreso() != null && new Date().after(actualizacion.getFechaIngreso())
				&& !empleado.getFechaIngreso().equals(actualizacion.getFechaIngreso())
				&& empleado.getFechaIngreso().after(empleado.getFechaNacimiento())) {
			empleado.setFechaIngreso(actualizacion.getFechaIngreso());
		}
		if (actualizacion.getFechaNacimiento() != null && new Date().after(actualizacion.getFechaNacimiento())
				&& !empleado.getFechaNacimiento().equals(actualizacion.getFechaNacimiento())) {
			empleado.setFechaNacimiento(actualizacion.getFechaNacimiento());
		}
		if (empleado.getSueldo() >= 0 && empleado.getSueldo() != actualizacion.getSueldo()) {
			empleado.setSueldo(actualizacion.getSueldo());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(empleado.getTelefono(), actualizacion.getTelefono())) {
			empleado.setTelefono(actualizacion.getTelefono());
		}
		empleado.setUbicacion(empleado.getUbicacion().actualizarUbicacion(empleado.getUbicacion(), actualizacion.getUbicacion()));

		return validarCreacionEmpleado(empleado);
	}
}
