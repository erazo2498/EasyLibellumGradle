package co.edu.co.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.co.domain.Empleado;
import co.edu.co.entity.EmpleadoEntity;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class EmpleadoConverter {

	public Empleado entityToModel(EmpleadoEntity entity) {
		return new Empleado(entity.getIdentificacion(),entity.getUsuario(),entity.getContrasena(),entity.getNombre(),
				entity.getApellido(),entity.getRol(),entity.getTelefono(),entity.getSueldo(),entity.getFechaIngreso(),
				entity.getFechaIngreso(),UbicacionConverter.entityToModel(entity.getUbicacion()));
	}
	
	public EmpleadoEntity modelToEntity(Empleado empleado) {
		EmpleadoEntity entidad = new EmpleadoEntity();
		entidad.setIdentificacion(empleado.getIdentificacion());
		entidad.setUsuario(empleado.getUsuario());
		entidad.setContrasena(empleado.getContrasena());
		entidad.setNombre(empleado.getNombre());
		entidad.setApellido(empleado.getApellido());
		entidad.setRol(empleado.getRol());
		entidad.setTelefono(empleado.getTelefono());
		entidad.setSueldo(empleado.getSueldo());
		entidad.setFechaIngreso(empleado.getFechaIngreso());
		entidad.setFechaNacimiento(empleado.getFechaNacimiento());
		entidad.setUbicacion(UbicacionConverter.modelToEntity(empleado.getUbicacion()));
		return entidad;
	}
	
	public List<Empleado> entityToModel(List<EmpleadoEntity> entidades) {
		List<Empleado> empleados = new ArrayList<Empleado>(entidades.size());
		entidades.forEach((entity) -> { empleados.add(entityToModel(entity)); });
		return empleados;
	}
}
