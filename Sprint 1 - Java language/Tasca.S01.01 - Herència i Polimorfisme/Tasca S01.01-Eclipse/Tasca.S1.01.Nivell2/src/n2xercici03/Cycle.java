package n2xercici03;

public class Cycle {
	protected int wheels;
	
	Cycle (){
		wheels=0;
	}
	public static void ride(Cycle c) {
		System.out.println(c.wheels());
	}
	public int wheels() {
		return wheels;
	}
}
