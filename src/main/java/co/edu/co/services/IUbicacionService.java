package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Ubicacion;

public interface IUbicacionService {
	
	List<Ubicacion> listAll();
	
	void save(Ubicacion ubicacion);

	Ubicacion findById(int id);

	void deleteById(Integer id);

}
