package co.edu.co.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.co.domain.DetalleFactura;
import co.edu.co.entity.DetalleFacturaEntity;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class DetalleFacturaConverter {

	public DetalleFactura entityToModel(DetalleFacturaEntity entity) {
		return new DetalleFactura(entity.getIdFactura(),entity.getCantidadProducto(),null/*ProductoConverter.entityToModel(entity.getProducto())*/);
	}
	
	public DetalleFacturaEntity modelToEntity(DetalleFactura detalle) {
		DetalleFacturaEntity entity = new DetalleFacturaEntity();
		entity.setIdFactura(detalle.getIdFactura());
		entity.setCantidadProducto(detalle.getCantidadProducto());
		//entity.setProducto(ProductoConverter.modelToEntity(detalle.getProducto()));
		return entity;
	}
	
	public List<DetalleFactura> entityToModel(List<DetalleFacturaEntity> detallesEntity) {
		List<DetalleFactura> detalles = new ArrayList<DetalleFactura>(detallesEntity.size());
		detallesEntity.forEach((entity) -> {
			detalles.add(entityToModel(entity));
		});
		return detalles;
	}
	
	public List<DetalleFacturaEntity> modelToentity(List<DetalleFactura> detallesFac) {
		List<DetalleFacturaEntity> detallesEnt = new ArrayList<DetalleFacturaEntity>(detallesFac.size());
		detallesFac.forEach((entity) -> {
			detallesEnt.add(modelToEntity(entity));
		});
		return detallesEnt;
	}
	
}
