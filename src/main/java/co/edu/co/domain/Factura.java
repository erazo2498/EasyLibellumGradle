package co.edu.co.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Factura {

	private long idFactura;
	private Date fechaVenta;
	private List<DetalleFactura> productosYCantidades;
	private double valorTotal;
	private Cliente cliente;
	private Empleado empleado;

	public Factura(long idFactura, Date fechaVenta, List<DetalleFactura> productosYCantidades, double valorTotal,
			Cliente cliente, Empleado empleado) {
		super();
		this.idFactura = idFactura;
		this.fechaVenta = UtilObjeto.utilObjeto().evitarNulos(fechaVenta, new Date());
		this.productosYCantidades = UtilObjeto.utilObjeto().evitarNulos(productosYCantidades,new ArrayList<DetalleFactura>());
		this.valorTotal = valorTotal;
		this.cliente = UtilObjeto.utilObjeto().evitarNulos(cliente, new Cliente());
		this.empleado = UtilObjeto.utilObjeto().evitarNulos(empleado, new Empleado());
	}

	public Factura validarCreacionFactura (Factura factura) throws Excepcion {
		if (factura.getIdFactura() <= 0) {
			throw new Excepcion("El codigo factura no puede ser menor o igual a cero");
		}
		if (new Date().before(factura.getFechaVenta())) {
			throw new Excepcion("La fecha no puede ser mayor a la actual");
		}
		if (factura.getProductosYCantidades().isEmpty() || factura.getProductosYCantidades().contains(null)) {
			throw new Excepcion("la factura debe contener 1 o más productos, no nulos");
		}
		for (DetalleFactura detalle : factura.getProductosYCantidades()) {
			if (detalle.getIdFactura() != factura.getIdFactura()) {
				throw new Excepcion("todos los detalles deben tener el mismo id que la factura");
			}
			detalle.validarCreacionDetalleFactura(detalle);
		}
		if (factura.getValorTotal() <= 0) {
			throw new Excepcion("la factura no puede ser menor o igual a cero");
		}
		factura.getCliente().validarCreacionCliente(factura.getCliente());
		factura.getEmpleado().validarCreacionEmpleado(factura.getEmpleado());

		return factura;
	}
}
