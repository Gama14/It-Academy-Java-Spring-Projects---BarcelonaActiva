package n1exercici4;
/* Modifica l'anterior apartat de manera que els arguments que rep f() 
 * sigui una llista d'arguments de variable indefinida.
 */
public class Main {

	public static void main(String[]args) {
		GenericMethods gm1 = new GenericMethods();
	
		gm1.f(1, "casa", 3.02,"pato", 3002);
		gm1.f(1,2,3);
		gm1.f("Pedro");
	

	
	}
}
	
