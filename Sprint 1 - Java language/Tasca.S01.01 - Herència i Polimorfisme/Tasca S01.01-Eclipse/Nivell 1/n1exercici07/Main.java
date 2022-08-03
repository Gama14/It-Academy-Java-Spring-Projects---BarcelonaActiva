package n1exercici07;

public class Main {
	public static void main (String[]args) {
		Frog f1 = new Frog ();
		f1.moure();
		f1.respirar();
		f1.menjar();
		f1.saltar();
		Amphibian a1 = new Amphibian ();
		a1.moure();
		a1.respirar();
		a1.menjar();
		//a1.saltar (); //--> dona error ja que el metode saltar no està definit a la classe Amphibian, 
		//ja que aquesta es la classe pare/mare i una classe general, mentre que Frog es la especialitzada
		// i la que conté el metode saltar()
	}
}
