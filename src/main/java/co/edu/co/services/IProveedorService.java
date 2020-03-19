package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Proveedor;

public interface IProveedorService {
	
	List <Proveedor> listAll();
	
	void save(Proveedor proveedor);

	Proveedor findById(String id);

	void deleteById(String id);


}
