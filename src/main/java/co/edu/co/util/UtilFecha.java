package co.edu.co.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha {

	private static final UtilFecha INSTANCIA = new UtilFecha();

	public UtilFecha() {
		super();
	}

	public static final UtilFecha utilFecha() {
		return INSTANCIA;
	}

	public final Date String_Date(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return fechaDate;
	}

}
