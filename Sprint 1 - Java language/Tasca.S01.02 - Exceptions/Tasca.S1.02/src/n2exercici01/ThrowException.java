package n2exercici01;

public class ThrowException {
	public void f() throws Exception2{
		try {
			g();
		}catch (Exception1 e){
			System.out.println("S'ha produït un error: "+ e.getMessage());
			throw new Exception2 ("Excepció 2");
		}
	}
	
	public void g() throws Exception1{
		throw new Exception1 ("Excepció 1");
	}
}
 

class Exception1 extends Exception{
	public Exception1 (String missatge) {
		super(missatge);
	}
}	
class Exception2 extends Exception{
	public Exception2 (String missatge) {
		super(missatge);
	}
}
