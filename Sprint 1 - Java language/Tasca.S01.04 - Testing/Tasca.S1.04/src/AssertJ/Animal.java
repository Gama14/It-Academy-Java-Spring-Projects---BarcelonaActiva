package AssertJ;

public class Animal implements Comparable <Animal> {
	private String type;
	
	Animal(String type){
		this.type=type;
	}

	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
