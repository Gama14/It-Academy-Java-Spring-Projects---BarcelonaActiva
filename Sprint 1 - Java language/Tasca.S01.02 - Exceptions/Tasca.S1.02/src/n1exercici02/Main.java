package n1exercici02;

public class Main {

	public static void main(String[] args) {
		Object arbre=null;
		try{
			arbre.toString();
		}catch (Exception e) {
			System.out.println("S'ha produït un error: " + e.getMessage()+ e.getClass());
		}

	}

}
