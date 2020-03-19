package co.edu.co.domain;

import java.util.Date;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import co.edu.co.util.UtilTexto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

	private String identificacion;
	private String nombre;
	private String apellido;
	private String telefono;
	private Date fechaNacimiento;
	private Ubicacion ubicacion;

	public Cliente(String identificacion ,String nombre, String apellido, String telefono, Date fechaNacimiento,Ubicacion ubicacion) {
		super();
		this.identificacion = UtilObjeto.utilObjeto().evitarNulos(identificacion, "").trim();
		this.nombre = UtilObjeto.utilObjeto().evitarNulos(nombre, "").trim();
		this.apellido = UtilObjeto.utilObjeto().evitarNulos(apellido, "").trim();
		this.telefono = UtilObjeto.utilObjeto().evitarNulos(telefono, "").trim();
		this.fechaNacimiento = UtilObjeto.utilObjeto().evitarNulos(fechaNacimiento, new Date());
		this.ubicacion = UtilObjeto.utilObjeto().evitarNulos(ubicacion, new Ubicacion());
	}

	private void validarStrings(String textoValidacion, String mensajeError) throws Excepcion {
		if (UtilTexto.obtenerUtilTexto().esVacioONull(textoValidacion)) {
			throw new Excepcion(mensajeError);
		}
	}

	public Cliente validarCreacionCliente(Cliente cliente) throws Excepcion {
		validarStrings(cliente.getNombre(), "El nombre no puede ser vacio o nulo");
		validarStrings(cliente.getApellido(), "El apellido no puede ser vacio o nulo");
		cliente.getUbicacion().validarCreacionUbicacion(cliente.getUbicacion());
		if (cliente.getFechaNacimiento() == null || new Date().before(cliente.getFechaNacimiento())
				|| new Date().equals(cliente.getFechaNacimiento())) {
			throw new Excepcion("La fecha de nacimiento debe ser antes de la fecha actual");
		}
		validarStrings(cliente.getIdentificacion(), "La identificacion no puede ser nula o vacia");
		if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty() || cliente.getTelefono().length() < 10) {
			throw new Excepcion("El telefono es necesario para contactar al clienteMalo y debe tener 10 caracteres");
		}
		return cliente;
	}

	public Cliente actualizarCliente(Cliente cliente, Cliente actualizacion) throws Excepcion {

		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(cliente.getNombre(), actualizacion.getNombre())) {
			cliente.setNombre(actualizacion.getNombre());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(cliente.getApellido(), actualizacion.getApellido())) {
			cliente.setApellido(actualizacion.getApellido());
		}
		if (actualizacion.getFechaNacimiento() != null && new Date().after(actualizacion.getFechaNacimiento())
				&& !cliente.getFechaNacimiento().equals(actualizacion.getFechaNacimiento())) {
			cliente.setFechaNacimiento(actualizacion.getFechaNacimiento());
		}
		if (UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(cliente.getTelefono(), actualizacion.getTelefono())) {
			cliente.setTelefono(actualizacion.getTelefono());
		}
		cliente.setUbicacion(cliente.getUbicacion().actualizarUbicacion(cliente.getUbicacion(), actualizacion.getUbicacion()));
		return validarCreacionCliente(cliente);
	}
}
