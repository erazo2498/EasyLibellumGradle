package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Empleado;

public interface IEmpleadoService {
	
	List<Empleado> listAll();
	
	void save(Empleado empleado);

	Empleado findById(String id);

	void deleteById(String id);

}
