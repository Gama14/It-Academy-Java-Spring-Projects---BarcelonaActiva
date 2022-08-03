package jUnit;

public class CalculoDni {
	private String letraDni;
	
	public CalculoDni (int numDni) {
		String juegoCaracteres="QAZWSXEDCRFVTGBYHNUJMIKOLP";
		int modulo = numDni % 25;
		this.letraDni = juegoCaracteres.charAt(modulo)+"";	
	}
	
	public String getLetra() {
		return letraDni;
	}
	
	
}

