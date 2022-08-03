package n2exercici01;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue <Numero> cola = new PriorityQueue<Numero>();
		 
		 cola.add(new Numero());
		 cola.add(new Numero());
		 cola.add(new Numero());
		 cola.add(new Numero());
		 
		  
		 while (!cola.isEmpty()) {
			  System.out.println(cola.poll().getNumRandom());
	     }
	}

}
