package n1exercici03;

public class Vehicle {
	static{ //només s'executarà una vegada
		System.out.println("Inicialització estàtica");
	}
	
	{ //s'executarà cada cop que s'instancï un objecte
		System.out.println("Inicialització per instància");
	}
	public Vehicle () {
		
	}
	public void iniciar () {
		System.out.println("El programa s'ha iniciat");
	}
	public static void parar() {
		System.out.println("Aquest es el mètode parar");
		
	}
	public void accelerar () {
		System.out.println ("Aquest es el mètode accelerar");
	}
}

