package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.DetalleFactura;

public interface IDetalleFacturaService {
	
	List<DetalleFactura> listAll();
	
	void save(DetalleFactura detalleFactura);

	DetalleFactura findById(long id);

	void deleteById(Long id);

}
