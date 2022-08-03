package n3.DependencyInjection;

public class LibraEsterlina implements ConversorMoneda {

	public double conversion(Articles a) {
		double preu= a.getPreu();
		return preu * 0.84;
	}
	
}
