package n3.Command;

public class Avion  implements Order {
	private Vehiculo avion;
	public Avion (Vehiculo avion) {
		this.avion=avion;
		
	}
	@Override
	public void execute() {
		avion.acelerar();
		avion.arrancar();
		avion.frenar();
		
	}


}

