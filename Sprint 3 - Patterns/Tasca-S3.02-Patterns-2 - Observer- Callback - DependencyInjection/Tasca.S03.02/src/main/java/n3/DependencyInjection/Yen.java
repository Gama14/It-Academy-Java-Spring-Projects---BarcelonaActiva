package n3.DependencyInjection;

public class Yen implements ConversorMoneda{
	public double conversion(Articles a) {
		double preu= a.getPreu();
		return preu * 131.27;
	}
}
