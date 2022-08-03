package n3.DependencyInjection;

public class Articles {
	protected double preu;
	protected String moneda;
	protected String name;
	
	Articles (double preu, String name){
		this.preu= preu;
		this.moneda= "euros";
		this.name=name;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
