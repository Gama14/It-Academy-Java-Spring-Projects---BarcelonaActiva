package n1exercici1;

public class Baby extends Persona{

	public Baby(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void caminar() {
		System.out.println("Estoy gateando!!");
	}
	
	@Deprecated
	public void llorar() {
		System.out.println("Estoy llorando!!");
	}

}
