package n1exercici06;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		LinkedList <Integer>llista= new LinkedList ();
		
		llista.add(100);
		llista.add(200);llista.add(300);llista.add(400);llista.add(500);llista.add(600);
		ListIterator<Integer>lit = llista.listIterator(llista.size()/2);
	
		lit.add(700);lit.add(800);lit.add(700);
		
		System.out.println(llista);
	}

}
