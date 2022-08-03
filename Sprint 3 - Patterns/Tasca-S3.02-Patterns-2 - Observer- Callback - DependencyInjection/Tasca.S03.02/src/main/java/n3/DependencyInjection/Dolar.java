package n3.DependencyInjection;

public class Dolar implements ConversorMoneda {

	@Override
	public double conversion(Articles a) {
		double preu= a.getPreu();
		return preu * 1.13;
	}
	
}
