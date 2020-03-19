package co.edu.co.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.Cliente;
import co.edu.co.domain.Ubicacion;
import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilFecha;


public class ClienteTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	Ubicacion lugar = new Ubicacion("Medellin", "Antioquia", "calle 45-12");
	Ubicacion lugarActualizacion = new Ubicacion("Rionegro", "antioquia","direccion");
	Ubicacion lugarVacio = new Ubicacion();

	String sfecha = "12/03/2019";
	String fechaActualizada = "11/04/2018";
	String fechafutura = "12/03/2020";

	Date fecha = UtilFecha.utilFecha().String_Date(sfecha);
	Date fecha1 = UtilFecha.utilFecha().String_Date(fechafutura);
	Date fecha2 = UtilFecha.utilFecha().String_Date(fechaActualizada);

	Cliente clienteMalo = new Cliente(null,null,null,null,null,null);
	Cliente clienteBueno = new Cliente("1234" ,"Andres", "Garcia", "1234567890",fecha,lugar);
	Cliente clienteLugarMalo = new Cliente("1234", "Andres", "Garcia", "123456",fecha,lugarVacio);
	Cliente clienteFechaMala = new Cliente("1234","Andres", "Garcia","123456", fecha1,lugar);
	Cliente clienteActualizacion = new Cliente("2ewqe","andres", "garcia","1010101010",fecha2,lugarActualizacion);

	@Test
	public void validarNombreDefecto()  {
		assertEquals("", clienteMalo.getNombre());
	}

	@Test
	public void validarApellidoDefecto()  {
		assertEquals("", clienteMalo.getApellido());
	}

	@Test
	public void validarUbicacionNula()  {
		assertNotNull(clienteMalo.getUbicacion());
	}

	@Test
	public void validarFechaNacimietoNula()  {
		assertNotNull(clienteMalo.getFechaNacimiento());
	}

	@Test
	public void validarIdentificacionDefecto()  {
		assertEquals("", clienteMalo.getIdentificacion());
	}

	@Test
	public void validarTelefonoDefecto()  {
		assertEquals("", clienteMalo.getTelefono());
	}

	@Test
	public void validarClienteBueno() throws Excepcion {
		assertEquals(clienteBueno.validarCreacionCliente(clienteBueno),clienteBueno);
	}

	@Test
	public void validarClienteFechaMala() throws Excepcion {
		exception.expect(Excepcion.class);
		clienteBueno.validarCreacionCliente(clienteFechaMala);
	}

	@Test
	public void validarClienteLugarvacio() throws Excepcion {
		exception.expect(Excepcion.class);
		clienteLugarMalo.validarCreacionCliente(clienteLugarMalo);
	}
	
	
	  @Test public void validarActualizacionNombre() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno, clienteActualizacion); assertEquals("andres",
	  clienteBueno.getNombre()); }
	  
	  @Test public void validarActualizacionApellido() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno,clienteActualizacion); assertEquals("garcia",
	  clienteBueno.getApellido()); }
	  
	  @Test public void validarActualizacionFecha() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno, clienteActualizacion); assertEquals(fecha2,
	  clienteBueno.getFechaNacimiento()); }
	  
	  @Test public void validarActualizacionTelefono() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno,clienteActualizacion);
	  assertEquals("1010101010", clienteBueno.getTelefono()); }
	  
	  @Test public void validarActualizacionCiudad() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno, clienteActualizacion); assertEquals("Rionegro",
	  clienteBueno.getUbicacion().getCiudad()); }
	  
	  @Test public void validarActualizacionDepartamento() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno, clienteActualizacion); assertEquals("antioquia",
	  clienteBueno.getUbicacion().getDepartamento()); }
	  
	  @Test public void validarActualizacionDireccion() throws Excepcion {
	  clienteBueno.actualizarCliente(clienteBueno, clienteActualizacion); assertEquals("direccion",
	  clienteBueno.getUbicacion().getDireccion()); } 
	 
}
