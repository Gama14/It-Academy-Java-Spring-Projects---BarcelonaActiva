package n1exercici02;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static void main(String[]args) {
		HashSet <Month> contenidor = new HashSet<Month>();
		Month m1 = new Month ("gener");
		Month m2 = new Month ("febrer");
		Month m3 = new Month ("febrer");
		
		
		contenidor.add(m1);
		contenidor.add(m1);
		contenidor.add(m1);
		contenidor.add(m2);
		//només afegirà al contenidor els objectes no duplicats
		for (Month o:contenidor) {
			System.out.println (o.getName());
		}
		
	}
}
