package n1fase2;

public class Main {
	public static void main(String[] args) {
		
		InterfacePi pi = () -> 3.14516;  //se instancia la interfaz mediante lambda
		System.out.println(pi.getPiValue());
		//System.out.println(pi);
		

	}
}
