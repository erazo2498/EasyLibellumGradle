package co.edu.co.util;

public class UtilObjeto {

	private static final UtilObjeto INSTANCIA = new UtilObjeto();

	private UtilObjeto() {
		super();
	}

	public static final UtilObjeto utilObjeto() {
		return INSTANCIA;
	}

	public final <T> T evitarNulos(final T objeto, final T valorDefecto) {

		return objeto==null?valorDefecto:objeto;
	}
}
