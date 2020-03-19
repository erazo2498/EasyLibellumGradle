package co.edu.co.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.co.converter.ClienteConverter;
import co.edu.co.domain.Cliente;
import co.edu.co.repository.IClienteRepository;
import co.edu.co.services.IClienteService;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private ClienteConverter converter;

	@Override
	public List<Cliente> listAll() {
		return converter.entityToModel(clienteRepository.findAll());
	}

	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(converter.modelToEntity(cliente));	
	}

	@Override
	public Cliente findById(String id) {
		return converter.entityToModel(clienteRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteById(String id) {
		clienteRepository.deleteById(id);
	}

}
