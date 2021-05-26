package mx.ipn.curso.ejercicios;

public class Parametros {
	public static void main(String[] args){
		System.out.println("Se recibieron: "+args.length+" parámetros");
		for(String parametro:args) {
			System.out.println("Parametro: "+parametro);
		}
	}
}
