package co.edu.co.util;

public class UtilTexto {

	private static final UtilTexto INSTANCIA = new UtilTexto();

	public UtilTexto() {
		super();
	}

	public static final UtilTexto obtenerUtilTexto() {
		return INSTANCIA;
	}

	public final boolean esVacioONull(String textoValidacion) {
		return (textoValidacion == null || textoValidacion.isEmpty());
	}

	public boolean validarContenidoActualizacion(String actual, String nuevo){
		return(!UtilTexto.obtenerUtilTexto().esVacioONull(nuevo) && !actual.equals(nuevo));
	}
}
