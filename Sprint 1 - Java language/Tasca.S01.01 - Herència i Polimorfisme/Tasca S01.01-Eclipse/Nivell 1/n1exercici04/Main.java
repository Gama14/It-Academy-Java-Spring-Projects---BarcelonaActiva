package n1exercici04;

public class Main {

	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle ();
		Vehicle v2 = new Vehicle ();
		//v1.color = "blau"; --> els atributs finals queden declarats com a constants i per tant
		//no es poden modificar durant l'execució del programa
		v1.setMarca("Honda"); //els atributs estàtics son propis de les clases i no dels objectes
		//per tant tots els objectes de la mateixa classe tindràn el mateix atribut, si es modifica, es modificarà per a tots
		System.out.println (v1.cavalls);
		System.out.println (v1.color);
		System.out.println (v2.marca);
	}
}
