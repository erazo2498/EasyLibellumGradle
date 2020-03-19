package co.edu.co.domain;

import java.util.Date;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Inventario {

	private Producto producto;
	private int cantidad;
	private Date fechaDeIngresoLote;
	private Date fechaVencimientoLote;

	public Inventario(Producto producto, int cantidad, Date fechaDeIngresoLote, Date fechaVencimientoLote) {
		super();
		this.producto = UtilObjeto.utilObjeto().evitarNulos(producto, new Producto());
		this.cantidad = cantidad;
		this.fechaDeIngresoLote = UtilObjeto.utilObjeto().evitarNulos(fechaDeIngresoLote, new Date());
		this.fechaVencimientoLote = UtilObjeto.utilObjeto().evitarNulos(fechaVencimientoLote, new Date());
	}

	public Inventario validarCreacionNuevoEntradaInventario(Inventario inventario) throws Excepcion {
		inventario.getProducto().validarCreacionProducto(inventario.getProducto());

		if (inventario.getCantidad() < 0) {
			throw new Excepcion("La cantidad no puede ser menor que cero");
		}
		if (inventario.getFechaVencimientoLote() == null
				|| inventario.getFechaVencimientoLote().before(inventario.getFechaDeIngresoLote())
				|| new Date().equals(inventario.getFechaVencimientoLote()) || inventario.getFechaVencimientoLote().before(new Date())) {
			throw new Excepcion("La fecha de vencimiento debe ser depues de la fecha actual");
		}
		if (inventario.getFechaDeIngresoLote() == null
				|| inventario.getFechaDeIngresoLote().after(inventario.getFechaVencimientoLote())
				|| inventario.getFechaDeIngresoLote().compareTo(new Date()) == 1) {
			throw new Excepcion("no se pueden ingresar lotes vencidos, ni del futuro");
		}
		return inventario;
	}	
}
