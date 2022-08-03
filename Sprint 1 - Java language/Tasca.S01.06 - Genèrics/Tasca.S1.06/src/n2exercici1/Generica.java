package n2exercici1;

public class Generica {

	public <T extends MyInterface> void metodeGeneric(T obj) {
		obj.metodo1();
		obj.metodo2();
	}
}
