package co.edu.co.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.Cliente;
import co.edu.co.domain.DetalleFactura;
import co.edu.co.domain.Empleado;
import co.edu.co.domain.Factura;
import co.edu.co.domain.Producto;
import co.edu.co.domain.Ubicacion;
import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilFecha;


public class FacturaTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	String sfecha = "12/03/2019";
	String fechafutura = "12/03/2050";

	Date fecha = UtilFecha.utilFecha().String_Date(sfecha);
	Date fechaFuturo = UtilFecha.utilFecha().String_Date(fechafutura);

	Ubicacion lugar = new Ubicacion("Medellin", "Antioquia", "calle 45-12");

	Producto producto = new Producto(22, "Fab", "Fab", 0.19, 5000, 5500);

	DetalleFactura detalleFac = new DetalleFactura((long) 12,2,producto);

	Empleado empleadoMalo = new Empleado();
	Empleado empleadoBueno = new Empleado("1", "2", "123456789", "4", "5", "6","1234567890",200,fecha, fecha, lugar);

	Cliente clienteMalo = new Cliente(null, null, null, null, null, null);
	Cliente clienteBueno = new Cliente("1234","Andres", "Garcia", "1234567890",fecha,lugar);

	List<DetalleFactura> detalles = new ArrayList<>();

	Factura factura = new Factura(0, null, null, 0, null, null);
	Factura facturaMala = new Factura(-1, fechaFuturo, new ArrayList<DetalleFactura>(), -1, clienteMalo, empleadoMalo);
	Factura facturaBuena = new Factura(12, fecha, detalles, 12, clienteBueno, empleadoBueno);
	Factura facturaDiferenteID = new Factura(11, fecha, new ArrayList<DetalleFactura>(), 12, clienteBueno,
			empleadoBueno);

	@Test
	public final void testValidarCodigo() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setIdFactura(0);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void validarCodigoFacturaNegativo() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setIdFactura(-1);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void validarCodigoFacturaPositivo() {
		assertEquals(12, facturaBuena.getIdFactura());
	}

	@Test
	public final void testValidarFecha() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setFechaVenta(fechaFuturo);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void validarFacturaConFechaNormal() throws Excepcion {
		exception.expect(Excepcion.class);
		facturaBuena.getProductosYCantidades().add(new DetalleFactura());
		assertEquals(facturaBuena.validarCreacionFactura(facturaBuena),facturaBuena);
	}

	@Test
	public final void testValidarArreglo() throws Excepcion{
		factura = facturaBuena;
		factura.getProductosYCantidades().add(detalleFac);
		factura.validarCreacionFactura(factura);
		assertEquals(detalles, factura.getProductosYCantidades());
	}

	@Test
	public final void testValidarArregloConDetalleNulo() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.getProductosYCantidades().add(null);
		factura.validarCreacionFactura(factura);
		assertEquals(detalles, factura.getProductosYCantidades());
	}

	@Test
	public final void validarArregloVacio() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.validarCreacionFactura(factura);
		assertEquals(detalles, factura.getProductosYCantidades());
	}

	@Test
	public final void testValidarValorTotal() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setValorTotal(0);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void validarValorFacturaNegativo() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setValorTotal(-1);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void testClienteMalo() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setCliente(clienteMalo);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void testEmpleadoMalo() throws Excepcion {
		exception.expect(Excepcion.class);
		factura = facturaBuena;
		factura.setEmpleado(empleadoMalo);
		factura.validarCreacionFactura(factura);
	}

	@Test
	public final void testValidarCreacionFactura() throws Excepcion {
		exception.expect(Excepcion.class);
		facturaBuena.getProductosYCantidades().add(new DetalleFactura());
		assertEquals(facturaBuena.validarCreacionFactura(facturaBuena),facturaBuena);
	}

	@Test
	public final void validarFacturaConArregloDeObjetosNulos() throws Excepcion {
		exception.expect(Excepcion.class);
		facturaBuena.getProductosYCantidades().add(null);
		assertEquals(facturaBuena.validarCreacionFactura(facturaBuena),facturaBuena);	}

	@Test
	public final void validarFacturaConDiferenteID() throws Excepcion {
		exception.expect(Excepcion.class);
		facturaDiferenteID.getProductosYCantidades().add(detalleFac);
		assertEquals(facturaDiferenteID.validarCreacionFactura(facturaDiferenteID),facturaDiferenteID);	}

	@Test
	public final void validarFacturaBuena() throws Excepcion {
		facturaBuena.getProductosYCantidades().add(detalleFac);
		assertEquals(facturaBuena.validarCreacionFactura(facturaBuena),facturaBuena);
	}

}
