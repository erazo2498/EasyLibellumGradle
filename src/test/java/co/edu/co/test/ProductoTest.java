package co.edu.co.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.Producto;
import co.edu.co.exceptions.Excepcion;


public class ProductoTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	Producto producto = new Producto(22, "Fab", "Fabs", 0.19, 5000, 5500);
	Producto productoVacio = new Producto();

	@Test
	public final void testValidarCodigoDeBarrasNegativo() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio = producto;
		productoVacio.setCodigoBarras(-1);
		producto.validarCreacionProducto(producto);
	}

	@Test
	public final void testValidarCodigoDeBarrasCero() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio = producto;
		productoVacio.setCodigoBarras(0);
		producto.validarCreacionProducto(productoVacio);
	}

	@Test
	public final void testValidarNombreProductoNulo() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio = producto;
		productoVacio.setNombre(null);
		producto.validarCreacionProducto(productoVacio);
	}

	@Test
	public final void testValidarNombreProducto() {
		assertEquals("Fab", producto.getNombre());
	}

	@Test
	public final void testValidarMarcaProducto() {
		assertEquals("Fabs", producto.getMarca());	
	}

	@Test
	public final void testValidarMarcaProductoNula() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio = producto;
		productoVacio.setMarca(null);
		producto.validarCreacionProducto(productoVacio);
	}

	@Test
	public final void testValidarIva()  {
		assertEquals(0.19, producto.getIva(),0.0);
	}

	@Test
	public final void testValidarPrecioCompra()  {
		assertEquals(5000, producto.getPrecioCompra(),0.0);	
	}

	@Test
	public final void testValidarPrecioVenta()  {
		assertEquals(5500, producto.getPrecioVenta(),0.0);	
	}

	@Test
	public final void testValidarPreciosMalos() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio = producto;
		productoVacio.setPrecioCompra(6000);
		productoVacio.setPrecioVenta(5500);
		producto.validarCreacionProducto(productoVacio);
	}

	@Test
	public final void testValidarIvaMayor() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio = producto;
		productoVacio.setIva(1.1);
		producto.validarCreacionProducto(productoVacio);
	}

	@Test
	public final void testValidarCreacionProductoVacio() throws Excepcion {
		exception.expect(Excepcion.class);
		productoVacio.validarCreacionProducto(productoVacio);
	}

	@Test
	public final void testValidarCreacionProducto() throws Excepcion {
		assertEquals(producto,productoVacio.validarCreacionProducto((producto)));	}

}
