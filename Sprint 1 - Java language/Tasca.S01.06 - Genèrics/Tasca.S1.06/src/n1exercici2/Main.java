package n1exercici2;
/*Exercici 2. Crea una classe anomenada GenericMethods amb un mètode genèric anomenat f()
 *que accepti tres arguments de tipus genèric. Realitza al main() diferents crides  d'aquest mètode 
 *amb diferents tipus de parametres. Comprova que es poden posar qualsevol tipus de variable. 
 */
public class Main {

	public static void main(String[]args) {
	GenericMethods gm1 = new GenericMethods();
	
	gm1.f(1, "casa", 3.02);
	
	gm1.f("Pedro","pato", 3002);
	
	}
}
	
