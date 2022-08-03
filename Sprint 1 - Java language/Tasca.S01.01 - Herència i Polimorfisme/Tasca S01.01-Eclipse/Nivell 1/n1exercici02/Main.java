package n1exercici02;

public class Main {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle ();
		// els mètodes estàtics pertanyen a la classe i no al objecte, per aquest motiu cridem a la classe per invocarlos
		Vehicle.parar();
		v1.accelerar();

	}

}
