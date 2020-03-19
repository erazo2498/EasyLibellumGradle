package co.edu.co.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.co.converter.FacturaConverter;
import co.edu.co.domain.Factura;
import co.edu.co.repository.IFacturaRepository;
import co.edu.co.services.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository repository;
	@Autowired
	private FacturaConverter converter;


	@Override
	public List<Factura> listAll() {
		return converter.entityToModel(repository.findAll());
	}

	@Override
	public void save(Factura factura) {
		repository.save(converter.modelToEntity(factura));
	}

	@Override
	public Factura findById(long id) {
		return converter.entityToModel(repository.findById(id).orElse(null));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
