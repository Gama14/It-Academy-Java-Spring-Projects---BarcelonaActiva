package n2.AbstractFactory;

public class Main {

	public static void main(String[] args) {
		 SpanishFactory contacto1 = new SpanishFactory("Ramon Perez","627891299","Carrer de Sants 123, Barcelona");
	     EnglishFactory contacto2 = new EnglishFactory("Christian Mars","47546282","Avenida Libertad 456, Mar del Plata");
	     
	     System.out.println(contacto1.getNombre()+ " || " + contacto1.getTelefono() +" || "+contacto1.getDireccion());
	     System.out.println(contacto2.getNombre()+ " || " + contacto2.getTelefono() +" || "+contacto2.getDireccion());
	}

}
