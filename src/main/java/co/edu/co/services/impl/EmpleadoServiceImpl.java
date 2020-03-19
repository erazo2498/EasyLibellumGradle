package co.edu.co.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.co.converter.EmpleadoConverter;
import co.edu.co.domain.Empleado;
import co.edu.co.repository.IEmpleadoRepository;
import co.edu.co.services.IEmpleadoService;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	@Autowired
	private EmpleadoConverter converter;

	@Override
	public List<Empleado> listAll() {
		return converter.entityToModel(empleadoRepository.findAll());
	}

	@Override
	public void save(Empleado empleado) {
		empleadoRepository.save(converter.modelToEntity(empleado));
	}

	@Override
	public Empleado findById(String id) {
		return converter.entityToModel(empleadoRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteById(String id) {
		empleadoRepository.deleteById(id);
	}
}
