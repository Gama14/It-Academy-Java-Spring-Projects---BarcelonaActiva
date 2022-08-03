package n2xercici04;

import java.util.ArrayList;

public class Main {
	 
	public static void main(String[] args) {
		ArrayList <Rossegador> bbddRossegador= new ArrayList <Rossegador>();
		Ratoli ratoli1 = new Ratoli();
		Jerbu jerbu1 = new Jerbu();
		Hamster hamster1 = new Hamster();
		
		bbddRossegador.add(ratoli1);
		bbddRossegador.add(jerbu1);
		bbddRossegador.add(hamster1);
		
		for (Rossegador r:bbddRossegador) {
			r.ensumar();
			r.rossegar();
			r.correr();
		}
	}
}
