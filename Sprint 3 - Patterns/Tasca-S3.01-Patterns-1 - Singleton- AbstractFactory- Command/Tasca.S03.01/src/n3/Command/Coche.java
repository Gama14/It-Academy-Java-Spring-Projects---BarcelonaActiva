package n3.Command;

public class Coche  implements Order{
	private Vehiculo coche;
	public Coche (Vehiculo coche) {
		this.coche=coche;
		
	}
	@Override
	public void execute() {
		coche.acelerar();
		coche.arrancar();
		coche.frenar();
		
	}

}
