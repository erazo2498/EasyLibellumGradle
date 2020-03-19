package co.edu.co.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.DetalleFactura;
import co.edu.co.domain.Producto;
import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilFecha;


public class DetalleFacturaTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	String sfecha = "12/03/2019";
	String fechafutura = "12/03/2020";

	Date fecha = UtilFecha.utilFecha().String_Date(sfecha);
	Date fecha1 = UtilFecha.utilFecha().String_Date(fechafutura);

	Producto producto = new Producto(22, "Fab", "Fab", 0.19, 5000, 5500);
	Producto productoDesfalco = new Producto(22, "Fab", "Fab", 0.19, 6000, 5500);

	DetalleFactura detalle = new DetalleFactura((long) 2,12, producto);
	DetalleFactura detalleMalo = new DetalleFactura((long) 2,12,productoDesfalco);

	@Test
	public void testValidarIdFactura() {
		assertEquals(2, detalle.getIdFactura());
	}

	@Test
	public void testValidarCantidadProductos() {
		assertEquals(12, detalle.getCantidadProducto());
	}

	@Test
	public void testValidarProducto() {
		assertEquals(producto, detalle.getProducto());
	}

	@Test
	public void testValidarCreacionDetalleFactura() throws Excepcion {
		assertEquals(detalle, detalle.validarCreacionDetalleFactura(detalle));
	}

	@Test
	public void testValidarCreacionDetalleFacturaPrecioCompramayor() throws Excepcion {
		exception.expect(Excepcion.class);
		assertEquals(detalleMalo, detalleMalo.validarCreacionDetalleFactura(detalleMalo));
	}

}
