package co.edu.co.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import co.edu.co.domain.Empleado;
import co.edu.co.domain.Ubicacion;
import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilFecha;



public class EmpleadoTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	Ubicacion lugar = new Ubicacion("Medellin", "Antioquia", "calle 45-12");
	Ubicacion lugarVacio = new Ubicacion("", "","");

	String sfecha = "12/03/2019";
	String fechafutura = "12/03/2050";
	String fechaIngreso = "12/03/1970";
	String fechaNacimiento = "12/03/1950";

	Date fecha = UtilFecha.utilFecha().String_Date(sfecha);
	Date fechaFuturo = UtilFecha.utilFecha().String_Date(fechafutura);
	Date fechaNacio = UtilFecha.utilFecha().String_Date(fechaNacimiento);
	Date fechaEntro = UtilFecha.utilFecha().String_Date(fechaIngreso);

	Empleado empleadoNoNacido = new Empleado();
	Empleado empleadoMalo = new Empleado("andres", "andres", "andres", "andres", "andres", "andres","1234567",-1111, fechaFuturo, fechaFuturo,lugarVacio);
	Empleado empleadoBueno = new Empleado("andres", "andres", "123456789", "andres", "andres", "andres","1234567890",1111,fecha, fechaNacio,lugar);

	@Test
	public final void testValidarIdentificacion() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setIdentificacion(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarUsuario() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setUsuario(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarContrasena() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setContrasena(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarNombre() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setNombre(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarApellido() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setApellido(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarRol() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setRol(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarFechaIngreso() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setFechaIngreso(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarFechaNacimiento() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setFechaNacimiento(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarFechaIngresoMal() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setFechaIngreso(fechaFuturo);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarFechaIngresoAntesNacimiento() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setFechaNacimiento(fechaEntro);
		empleadoNoNacido.setFechaIngreso(fechaNacio);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarFechaNacimientoMal() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setFechaNacimiento(fechaFuturo);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarSueldo() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setSueldo(0);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarSueldoNegativo() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setSueldo(-1);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarTelefono() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setTelefono(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarTelefonoMalo() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setTelefono("012345678");
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarUbicacion() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setTelefono(null);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarUbicacionMala() throws Excepcion {
		exception.expect(Excepcion.class);
		empleadoNoNacido = empleadoBueno;
		empleadoNoNacido.setUbicacion(lugarVacio);
		empleadoNoNacido.validarCreacionEmpleado(empleadoNoNacido);
	}

	@Test
	public final void testValidarCreacionEmpleadoBueno() throws Excepcion {
		assertEquals(empleadoBueno, empleadoBueno.validarCreacionEmpleado(empleadoBueno));
	}

}
