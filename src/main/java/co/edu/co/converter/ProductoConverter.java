package co.edu.co.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.co.domain.Producto;
import co.edu.co.entity.ProductoEntity;

@Component
public class ProductoConverter {

	public static  Producto entityToModel(ProductoEntity producto) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ProductoEntity modelToEntity(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Producto> entityToModel(List<ProductoEntity> productosEntity) {
		List<Producto> productos = new ArrayList<Producto>(productosEntity.size());
		productosEntity.forEach((entity) -> {
			productos.add(entityToModel(entity));
		});
		return productos;
	}
	
	public List<ProductoEntity> modelToEntity(List<Producto> productos) {
		List<ProductoEntity> productosEntity = new ArrayList<ProductoEntity>(productos.size());
		productos.forEach((model) -> {
			productosEntity.add(modelToEntity(model));
		});
		return productosEntity;
	}

}
