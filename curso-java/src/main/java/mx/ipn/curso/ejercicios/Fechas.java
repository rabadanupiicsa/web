package mx.ipn.curso.ejercicios;

import java.util.Date;

public class Fechas {
	private static final String[] MONTH_NAMES = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio","Agosto","Septiembre","Octubre","Nobriembre","Diciembre"};
	private static final String[] DAY_NAMES = new String[]{"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date fecha = new Date();
		System.out.println("La fecha del día de hoy es: "+ DAY_NAMES[fecha.getDay()]+" "+fecha.getDate()+" de "+ MONTH_NAMES[fecha.getMonth()]+" de "+(fecha.getYear()+1900));
	}
}
