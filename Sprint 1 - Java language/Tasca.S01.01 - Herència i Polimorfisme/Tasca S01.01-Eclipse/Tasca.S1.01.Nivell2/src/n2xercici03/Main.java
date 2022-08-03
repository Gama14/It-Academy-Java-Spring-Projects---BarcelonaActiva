package n2xercici03;
import java.util.ArrayList;
public class Main {
	
	public static void main(String[] args) {
		ArrayList <Cycle> bbddCycle = new ArrayList <Cycle>();
		Tricycle t1 = new Tricycle();
		Bicycle b1 = new Bicycle();
		Unicycle c1 = new Unicycle();
	
		bbddCycle.add(t1);
		bbddCycle.add(b1);
		bbddCycle.add(c1);
		
		for (int i=0;i<bbddCycle.size(); i++) {
			if(bbddCycle.get(i) instanceof Bicycle) {
				((Bicycle) bbddCycle.get(i)).balance();
			}else if (bbddCycle.get(i) instanceof Unicycle) {
				((Unicycle) bbddCycle.get(i)).balance();
			}else {
				System.out.println("Aquest objecte no te el mètode balance");
			}
		}
	}

}
