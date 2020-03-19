package co.edu.co.domain;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilObjeto;
import co.edu.co.util.UtilTexto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Proveedor {

	private String nit;
	private String nombre;
	private String telefono;
	private List<Producto> productos;
	private Ubicacion ubicacion;

	public Proveedor(String nit, String nombre, String telefono, List<Producto> productos,Ubicacion ubicacion) {
		super();
		this.nit = UtilObjeto.utilObjeto().evitarNulos(nit, "").trim();
		this.nombre = UtilObjeto.utilObjeto().evitarNulos(nombre, "").trim();
		this.telefono = UtilObjeto.utilObjeto().evitarNulos(telefono, "").trim();
		this.productos = UtilObjeto.utilObjeto().evitarNulos(productos, new ArrayList<Producto>());
		this.ubicacion = UtilObjeto.utilObjeto().evitarNulos(ubicacion, new Ubicacion());
	}

	private void validarStrings(String textoValidacion, String mensajeError) throws Excepcion {
		if (UtilTexto.obtenerUtilTexto().esVacioONull(textoValidacion)) {
			throw new Excepcion(mensajeError);
		}
	}

	public Proveedor validarCreacionProvedor(Proveedor proveedor) throws Excepcion {
		validarStrings(proveedor.getNombre(), "El nombre no puede ser vacio o nulo");
		validarStrings(proveedor.getNit(), "El NIT no puede ser vacio o nulo");

		if (proveedor.getTelefono() == null || proveedor.getTelefono().isEmpty()
				|| proveedor.getTelefono().length() < 10) {
			throw new Excepcion("El telefono es necesario para contactar al Proveedor y debe tener 10 caracteres");
		}
		if (proveedor.getProductos().isEmpty() || proveedor.getProductos().contains(null)) {
			throw new Excepcion("El proveedor debe vender 1 o más productos, no nulos ni vacios");
		}
		for (Producto producto : proveedor.getProductos()) {
			producto.validarCreacionProducto(producto);
		}

		proveedor.getUbicacion().validarCreacionUbicacion(proveedor.getUbicacion());

		return proveedor;
	}
}
