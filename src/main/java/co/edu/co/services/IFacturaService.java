package co.edu.co.services;

import java.util.List;

import co.edu.co.domain.Factura;

public interface IFacturaService {

	List <Factura> listAll();

	void save(Factura factura);

	Factura findById(long id);

	void deleteById(Long id);

}
