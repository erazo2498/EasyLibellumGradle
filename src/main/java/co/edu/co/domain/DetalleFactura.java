package co.edu.co.domain;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetalleFactura {

	private long idFactura;
	private int cantidadProducto;
	private Producto producto;

	public DetalleFactura(Long idFactura, int cantidadProducto, Producto producto) {
		super();
		this.idFactura = idFactura;
		this.cantidadProducto = cantidadProducto;
		this.producto = UtilObjeto.utilObjeto().evitarNulos(producto, new Producto());
	}

	public DetalleFactura validarCreacionDetalleFactura (DetalleFactura detalle) throws Excepcion {
		if (detalle.getIdFactura() <= 0) {
			throw new Excepcion("El id de la factura no puede ser nulo");
		}
		if (detalle.getCantidadProducto() < 1) {
			throw new Excepcion("La cantidad del producto deber ser igual o mayor a uno");
		}
		detalle.getProducto().validarCreacionProducto(detalle.getProducto());
		return detalle;
	}
}
