package co.edu.co.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.co.domain.Factura;
import co.edu.co.entity.FacturaEntity;

@Component
public class FacturaConverter {

	@Autowired
	ClienteConverter cliente; 
	@Autowired
	DetalleFacturaConverter detalle;
	@Autowired
	EmpleadoConverter empleado;
	
	public Factura entityToModel(FacturaEntity entity) {
		return new Factura(entity.getIdFactura(), entity.getFechaVenta(),null/*detalle.entityToModel(entity.getProductosYCantidades())*/, 
				entity.getValorTotal(),null/*cliente.entityToModel(entity.getCliente())*/,null/*empleado.entityToModel(entity.getEmpleado())*/);
	}
	
	public FacturaEntity modelToEntity(Factura factura) {
		FacturaEntity entity = new FacturaEntity();
		entity.setIdFactura(factura.getIdFactura());
		entity.setFechaVenta(factura.getFechaVenta());
		//entity.setProductosYCantidades(detalle.modelToentity(factura.getProductosYCantidades()));
		entity.setValorTotal(factura.getValorTotal());
		//entity.setCliente(cliente.modelToEntity(factura.getCliente()));
		//entity.setEmpleado(empleado.modelToEntity(factura.getEmpleado()));
		return entity;
	}

	public List<Factura> entityToModel(List<FacturaEntity> entidadesFac) {
		List<Factura> facturas = new ArrayList<Factura>(entidadesFac.size());
		entidadesFac.forEach((entity) -> { facturas.add(entityToModel(entity)); }); 
		return facturas;
	}

}
