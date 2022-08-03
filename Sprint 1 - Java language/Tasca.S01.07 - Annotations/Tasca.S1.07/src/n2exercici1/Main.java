package n2exercici1;
import com.google.gson.*;
public class Main {
	public static void main(String[] args) {

		Jugador[] jugadors = new Jugador[10];
		for (int i = 1; i <= 10; i++) {
			jugadors[i - 1] = new Jugador(i, "Nom Jugador " + i, "Cognoms Juagdor " + i);
		}

		JugadorWrapper jugadorWrapper = new JugadorWrapper();
		System.out.println("-------------------------------");
		System.out.println("Dades anotació:");
		System.out.println(jugadorWrapper.getFileToSerialize());
		System.out.println("-------------------------------");

		//Serialtizem un o diversos jugadors
		jugadorWrapper.serialitzarJugador(jugadors[0]);
		//jugadorWrapper.serialitzaArrayJugadores(jugadors);
		
		

	}

}
