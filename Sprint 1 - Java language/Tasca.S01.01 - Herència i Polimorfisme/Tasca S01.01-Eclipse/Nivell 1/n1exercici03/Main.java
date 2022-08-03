package n1exercici03;

public class Main {

	public static void main(String[] args) {
		//El códi del bloc d'inicialització estàtioca s'executarà un cop en el moment de carregar la classe
		//i nomes ho farà un cop. Mentre que si es fa una inicialització per instància cada cop que es cridi 
		//a un objecte de la classe aquell bloc s'executarà
		Vehicle v1 = new Vehicle ();
		Vehicle v2 = new Vehicle ();
		Vehicle v3 = new Vehicle ();
	}
}
