package co.edu.co.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.Inventario;
import co.edu.co.domain.Producto;
import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilFecha;



public class InventarioTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	String sfecha = "12/03/2019";
	String fechafutura = "12/03/2050";
	String fechaPasada ="05/01/2019"; 

	Date fecha = UtilFecha.utilFecha().String_Date(sfecha);
	Date fechaFuturo = UtilFecha.utilFecha().String_Date(fechafutura);
	Date fechaPasado = UtilFecha.utilFecha().String_Date(fechaPasada);

	Producto producto = new Producto(22, "Fab", "Fab", 0.19, 5000, 5500);
	Producto productoMalo = new Producto(22, "Fab", "Fab", 1.1, 5000, 5500);

	Inventario inventario = new Inventario(producto, 0, fechaPasado, fechaFuturo);
	Inventario inventarioMalo = new Inventario(productoMalo, -1, fechaFuturo, fecha);

	@Test
	public final void testValidarProducto() {
		assertEquals(producto, inventario.getProducto());
	}

	@Test
	public final void testValidarProductoMalo() throws Excepcion {
		exception.expect(Excepcion.class);
		inventarioMalo = inventario;
		inventarioMalo.setProducto(productoMalo);
		inventarioMalo.validarCreacionNuevoEntradaInventario(inventarioMalo);
	}

	@Test
	public final void testValidarCantidadnegativa() throws Excepcion {
		exception.expect(Excepcion.class);
		inventarioMalo = inventario;
		inventarioMalo.setCantidad(-1);
		inventarioMalo.validarCreacionNuevoEntradaInventario(inventarioMalo);
	}

	@Test
	public final void testValidarCantidad() {
		assertEquals(0, inventario.getCantidad(), 0.0);
	}

	@Test
	public final void testValidarFechaVencimiento() throws Excepcion {
		inventario.validarCreacionNuevoEntradaInventario(inventario);
		assertEquals(fechaFuturo, inventario.getFechaVencimientoLote());
	}

	@Test
	public final void testValidarFechaVencimientoMala() throws Excepcion {
		exception.expect(Excepcion.class);
		inventarioMalo = inventario;
		inventarioMalo.setFechaVencimientoLote(fecha);
		inventarioMalo.validarCreacionNuevoEntradaInventario(inventarioMalo);
	}

	@Test
	public final void testValidarFechaIngresoLote() throws Excepcion {
		inventario.validarCreacionNuevoEntradaInventario(inventario);
		assertEquals(fechaPasado, inventario.getFechaDeIngresoLote());
	}

	@Test
	public final void testValidarFechaIngresoLoteMala() throws Excepcion {
		exception.expect(Excepcion.class);
		inventarioMalo = inventario;
		inventarioMalo.setFechaDeIngresoLote(fechaFuturo);
		inventarioMalo.validarCreacionNuevoEntradaInventario(inventarioMalo);
	}

	@Test
	public final void testValidarCreacionNuevoEntradaInventario() throws Excepcion {
		assertEquals(inventario.validarCreacionNuevoEntradaInventario(inventario), inventario);
	}

}
