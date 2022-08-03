package n1.Singleton;

import java.util.ArrayList;

public class Undo {
	
	private static Undo comando;
	private ArrayList<String> memoria=new ArrayList<String>();
	
	//fem el constructor privat per evitar que utilitzin l'operador new
	private Undo() {
		
	}
	//creem un mètode de creació estàtic que funcioni com a constructor
	public static Undo getComando() {
		if(comando==null) {
			comando= new Undo();
		}
		return comando;
	}
	
	public void history() {
		System.out.println(memoria);
	}


	public void addComando(String comando) {
		memoria.add(comando);
		
	}
	
	public void eliminarUltimoComando() {
		if (memoria.isEmpty()==false) {
			memoria.remove(memoria.size()-1);
		}
	}
	

}
