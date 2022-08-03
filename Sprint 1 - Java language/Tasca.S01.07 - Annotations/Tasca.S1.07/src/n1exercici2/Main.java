package n1exercici2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Baby bebe1= new Baby ("Pol", 2);
		Teenager teen1= new Teenager ("Susana", 15);
		
		bebe1.caminar();
		bebe1.hablar();
		System.out.println(bebe1.toString());
		teen1.caminar();
		teen1.hablar();
		System.out.println(teen1.toString());

	}

}
