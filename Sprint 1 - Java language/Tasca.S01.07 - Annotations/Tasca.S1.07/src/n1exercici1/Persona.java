package n1exercici1;

public class Persona {
 
	private String name;
	private int age;
	
	public Persona (String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void caminar() {
		System.out.println("Estoy caminando!!");
		
	}
	 public void hablar(){
		System.out.println("Estoy hablando!!");

	 }
	 public String toString() {
		 
		 return "Se llama "+name+ " y tiene "+ age+  " años.";
	 }
}
