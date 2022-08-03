package n1.Observer;

public class AgenciesBorsa implements Observer{

	private String name;
	
	AgenciesBorsa(String name){
		this.name=name;
	}
	
	@Override
	public void update() {
		System.out.println("La Agencia "+ name+ " notificada!");
		
		
		
	}

}
