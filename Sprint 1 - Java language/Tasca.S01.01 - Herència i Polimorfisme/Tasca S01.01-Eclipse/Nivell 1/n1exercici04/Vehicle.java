package n1exercici04;

public class Vehicle {
	
	public static final int cavalls = 180;
	public final String color;
	public static String marca;
	
	// un atribut final, com es color, nomes es pot incialitzar en el constructor de la clase
	// els atributs estatics es poden inicialitzar en els constructors i també es poden modificar posteriorment
	public Vehicle () {
		color="vermell";
		marca= "Peugeot";
	}
	
	
	public static String getMarca() {
		return marca;
	}
	public static void setMarca(String marca) {
		Vehicle.marca = marca;
	}
	public static int getCavalls() {
		return cavalls;
	}
	public String getColor() {
		return color;
	}
	//no es poden crear setters d'atributs finals, ja que aquests seran constants i no es podran modificar
	
	
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

