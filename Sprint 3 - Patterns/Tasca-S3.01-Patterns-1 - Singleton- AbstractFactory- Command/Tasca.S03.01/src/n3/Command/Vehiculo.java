package n3.Command;

public class Vehiculo {
	protected String tipo;
	
	public Vehiculo (String tipo) {
		this.tipo=tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void arrancar () {
		System.out.println("Este " +tipo+ " arranca");
	}
	public void acelerar() {
		System.out.println("Este " +tipo+ " acelera");
	}
	public void frenar () {
		System.out.println("Este " +tipo+ " frena \n");
	}
	
}
