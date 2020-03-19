package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Cliente;

public interface IClienteService {
	
	List<Cliente> listAll();
	
	void save(Cliente cliente);

	Cliente findById(String id);

	void deleteById(String id);

}
