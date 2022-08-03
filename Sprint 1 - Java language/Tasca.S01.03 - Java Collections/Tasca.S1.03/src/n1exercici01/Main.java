package n1exercici01;

import java.util.ArrayList;

public class Main {
	public static void main(String[]args) {
		ArrayList <Month> contenidor = new ArrayList<Month>();
		Month m1 = new Month ("gener");
		Month m2 = new Month ("febrer");
		Month m3 = new Month ("març");
		Month m4 = new Month ("abril");
		Month m5 = new Month ("maig");
		Month m6 = new Month ("juny");
		Month m7 = new Month ("juliol");
		Month m8 = new Month ("agost");
		Month m9 = new Month ("septembre");
		Month m10 = new Month ("octubre");
		Month m11 = new Month ("novembre");
		Month m12 = new Month ("desembre");
		//Afegim tots els mesos menys Agost
		contenidor.add(m1);
		contenidor.add(m2);
		contenidor.add(m3);
		contenidor.add(m4);
		contenidor.add(m5);
		contenidor.add(m6);
		contenidor.add(m7);
		contenidor.add(m9);
		contenidor.add(m10);
		contenidor.add(m11);
		contenidor.add(m12);
		//Afegim Agost en l'index 7 
		contenidor.add(7,m8);
		
		for (Month o:contenidor) {
			System.out.println (o.getName());
		}
		
	}
}
