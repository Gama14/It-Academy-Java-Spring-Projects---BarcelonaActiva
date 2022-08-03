package n1exercici03;

public class Main {

	public static void main(String[] args) {
		
		try{
			int[] nombres = {1,3,6}; 
			System.out.println(nombres[8]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("S'ha produït un error: "+ e.getMessage());
		}
		
	}

}
