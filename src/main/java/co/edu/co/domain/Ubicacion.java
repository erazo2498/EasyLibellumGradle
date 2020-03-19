package co.edu.co.domain;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import co.edu.co.util.UtilTexto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ubicacion {

	private String ciudad;
	private String departamento;
	private String direccion;

	public Ubicacion(String ciudad, String departamento, String direccion) {
		super();
		this.ciudad = UtilObjeto.utilObjeto().evitarNulos(ciudad, "").trim();
		this.departamento = UtilObjeto.utilObjeto().evitarNulos(departamento, "").trim();
		this.direccion = UtilObjeto.utilObjeto().evitarNulos(direccion, "").trim();
	}

	private void validarStrings(String textoValidacion, String mensajeError) throws Excepcion {
		if (UtilTexto.obtenerUtilTexto().esVacioONull(textoValidacion)) {
			throw new Excepcion(mensajeError);
		}
	}

	public Ubicacion validarCreacionUbicacion(Ubicacion ubicacion) throws Excepcion {
		validarStrings(ubicacion.getCiudad(), "La ciudad no puede estar vacia o nula");
		validarStrings(ubicacion.getDepartamento(), "El departamento no puede estar vacio o nulo");
		validarStrings(ubicacion.getDireccion(), "La direccion no puede estar vacio o nula");
		return ubicacion;
	}

	public Ubicacion actualizarUbicacion(Ubicacion ubicacion, Ubicacion actualizacion) throws Excepcion {
		if(UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(ubicacion.getCiudad(), actualizacion.getCiudad())) {
			ubicacion.setCiudad(actualizacion.getCiudad());
		}
		if(UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(ubicacion.getDepartamento(), actualizacion.getDepartamento())) {
			ubicacion.setDepartamento(actualizacion.getDepartamento());
		}
		if(UtilTexto.obtenerUtilTexto().validarContenidoActualizacion(ubicacion.getDireccion(), actualizacion.getDireccion())) {
			ubicacion.setDireccion(actualizacion.getDireccion());
		}
		return validarCreacionUbicacion(ubicacion);
	}
}
