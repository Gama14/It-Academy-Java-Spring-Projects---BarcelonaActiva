package AssertJ;

public class Persona implements Comparable <Persona> {
	private String nom;
	private int edad;
	
	Persona(String nom, int edad){
		this.nom=nom;
		this.edad=edad;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


