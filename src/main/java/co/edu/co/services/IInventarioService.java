package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Inventario;

public interface IInventarioService {
	
	List<Inventario> listAll();
	
	void save(Inventario inventario);

	Inventario findById(int id);

	void deleteById(Integer id);
	
}
