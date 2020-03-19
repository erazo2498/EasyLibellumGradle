package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Producto;

public interface IProductoService {
	
	List<Producto> listAll();
	
	void save(Producto producto);

	Producto findById(int id);

	void deleteById(Integer id);

}
