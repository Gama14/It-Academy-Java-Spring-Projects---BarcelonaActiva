package n2exercici01;

public class Main {

	public static void main(String[] args) {
		ThrowException e1 = new ThrowException();
		try{
			e1.f();
		} catch (Exception2 e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			
		}
		
	}
	
}
