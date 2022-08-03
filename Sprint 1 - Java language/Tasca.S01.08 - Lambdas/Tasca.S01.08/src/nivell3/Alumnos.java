package nivell3;

public class Alumnos {

	String nombre; 
	int edad; 
	String curso; 
	float nota;
	
	public Alumnos(String nombre, int edad, String curso, float nota) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumnos [nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + ", nota=" + nota  /*", getNom()=" + getNombre()
				+ ", getEdad()=" + getEdad() + ", getCurs()=" + getCurso() + ", getNota()=" + getNota() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]"*/;
	}

	
}