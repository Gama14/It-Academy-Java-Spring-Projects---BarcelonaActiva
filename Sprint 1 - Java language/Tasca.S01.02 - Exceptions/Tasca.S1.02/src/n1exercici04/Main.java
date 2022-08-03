package n1exercici04;

public class Main {

	public static void main(String[] args) {
		
		try{
			throw new MyException ("Aquesta es la meva excepció. ");
			
		}catch (MyException e) {
			System.out.println("S'ha produït un error: "+ e.getMessage()+e.getClass());
		}

	}

}
