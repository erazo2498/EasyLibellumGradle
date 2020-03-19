package co.edu.co.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.Producto;
import co.edu.co.domain.Proveedor;
import co.edu.co.domain.Ubicacion;
import co.edu.co.exceptions.Excepcion;

public class ProveedorTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	List<Producto> productos = new ArrayList<>();

	Ubicacion lugar = new Ubicacion("Medellin", "Antioquia", "calle 45-12");
	Ubicacion lugarVacio = new Ubicacion();

	Producto producto = new Producto(22, "Fab", "Fab", 0.19, -5000, -5500);
	Producto productoBueno = new Producto(22, "Fab", "Fab", 0.19, 5000, 5500);

	Proveedor proveedorMalo = new Proveedor();
	Proveedor proveedorBueno = new Proveedor("122", "Andres","01234567891", productos, lugar);

	@Test
	public final void testValidarNombre() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setNombre(null);
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarIdentificacion() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setNit(null);
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarTelefonoNulo() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setTelefono(null);
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarTelefonoMalo() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setTelefono("123456789");
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarProductos() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setProductos(productos);
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarProductosMalo() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setProductos(productos);
		proveedorMalo.getProductos().add(producto);
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarProductosBueno() throws Excepcion {
		proveedorBueno.getProductos().add(productoBueno);
		proveedorBueno.validarCreacionProvedor(proveedorBueno);
		assertEquals(productos, proveedorBueno.getProductos());
	}

	@Test
	public final void testValidarUbicacion() throws Excepcion {
		exception.expect(Excepcion.class);
		proveedorMalo = proveedorBueno;
		proveedorMalo.setProductos(productos);
		proveedorMalo.getProductos().add(producto);
		proveedorMalo.setUbicacion(lugarVacio);
		proveedorMalo.validarCreacionProvedor(proveedorMalo);
	}

	@Test
	public final void testValidarCreacionProvedor() throws Excepcion {
		exception.expect(Excepcion.class);
		assertEquals(proveedorMalo.validarCreacionProvedor(proveedorMalo),proveedorMalo);
	}

	@Test
	public final void testValidarCreacionProvedorBueno() throws Excepcion {
		proveedorBueno.getProductos().add(productoBueno);
		assertEquals(proveedorBueno.validarCreacionProvedor(proveedorBueno),proveedorBueno);
	}

}
