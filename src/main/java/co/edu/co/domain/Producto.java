package co.edu.co.domain;

import static co.edu.co.util.UtilObjeto.utilObjeto;

import co.edu.co.exceptions.Excepcion;
import co.edu.co.util.UtilTexto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto {

	private int codigoBarras;
	private String nombre;
	private String marca;
	private double iva;
	private double precioCompra;
	private double precioVenta;

	public Producto(int codigoBarras, String nombre, String marca, double iva, double precioCompra, double precioVenta) {
		super();
		this.codigoBarras = codigoBarras;
		this.iva = iva;
		this.marca = utilObjeto().evitarNulos(marca, "").trim();
		this.nombre = utilObjeto().evitarNulos(nombre, "").trim();
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	private void validarStrings(String textoValidacion, String mensajeError) throws Excepcion {
		if (UtilTexto.obtenerUtilTexto().esVacioONull(textoValidacion)) {
			throw new Excepcion(mensajeError);
		}
	}

	public Producto validarCreacionProducto(Producto producto) throws Excepcion {
		if (producto.getCodigoBarras() <= 0) {
			throw new Excepcion("El codigo del producto no puede ser menor o igual a cero");
		}
		validarStrings(producto.getNombre(), "El nombre del producto no puede estar vacio");
		validarStrings(producto.getMarca(), "La marca del producto no puede estar vacio");
		if (producto.getIva() <= 0.0 || producto.getIva() >= 1.0) {
			throw new Excepcion("El iva tienque que ser un porcentaje entre cero y uno");
		}
		if (producto.getPrecioCompra() <= 0 || producto.getPrecioCompra() >= producto.getPrecioVenta()
				|| producto.getPrecioVenta() <= 0 || producto.getPrecioVenta() <= producto.getPrecioCompra()) {
			throw new Excepcion("Ambos precios deben ser mayores a cero y el precio de venta debe ser mayor al de compra");
		}
		return producto;
	}
}
