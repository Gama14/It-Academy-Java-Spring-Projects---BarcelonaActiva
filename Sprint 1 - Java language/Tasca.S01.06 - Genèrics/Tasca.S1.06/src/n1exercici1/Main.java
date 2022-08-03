package n1exercici1;

/*Exercici 1. Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes
 *  del mateix tipus, juntament amb els mètodes per a emmagatzemar i extreure aquests 
 *  objectes i un constructor per a inicialitzar els tres. Comprova que els arguments 
 *  es poden posar en qualsevol posició en la crida al constructor.
 */


public class Main {
	public static void main(String[]args) {
	
	NoGenericMethods ngm1 = new NoGenericMethods (1,2,3);
	NoGenericMethods ngm2 = new NoGenericMethods (2,3,1);
	NoGenericMethods ngm3 = new NoGenericMethods (3,1,2);
	
	}
}
