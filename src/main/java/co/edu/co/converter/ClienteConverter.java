package co.edu.co.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.co.domain.Cliente;
import co.edu.co.entity.ClienteEntity;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ClienteConverter {

	public Cliente entityToModel(ClienteEntity entity) {
		return new Cliente(entity.getIdentificacion(), entity.getNombre(), entity.getApellido(),
				entity.getTelefono(), entity.getFechaNacimiento(),
				UbicacionConverter.entityToModel(entity.getUbicacion()));

	}

	public ClienteEntity modelToEntity(Cliente cliente) {
		ClienteEntity entidad = new ClienteEntity();
		entidad.setIdentificacion(cliente.getIdentificacion());
		entidad.setNombre(cliente.getNombre());
		entidad.setApellido(cliente.getApellido());
		entidad.setTelefono(cliente.getTelefono());
		entidad.setFechaNacimiento(cliente.getFechaNacimiento());
		entidad.setUbicacion(UbicacionConverter.modelToEntity(cliente.getUbicacion()));
		return entidad;
	}

	public List<Cliente> entityToModel(List<ClienteEntity> clientesEntity) {
		List<Cliente> clientes = new ArrayList<Cliente>(clientesEntity.size());
		clientesEntity.forEach((entity) -> {
			clientes.add(entityToModel(entity));
		});
		return clientes;
	}

}
