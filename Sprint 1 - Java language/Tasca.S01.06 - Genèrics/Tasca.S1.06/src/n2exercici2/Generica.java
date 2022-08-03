package n2exercici2;

public class Generica {

	public <T extends MyInterface1> void metode1(T obj) {
		obj.metodo1();
		obj.metodo2();
	}
	
	public <T extends MyInterface2> void metode2(T obj) {
		obj.metodo3();
		obj.metodo4();
	}
}
