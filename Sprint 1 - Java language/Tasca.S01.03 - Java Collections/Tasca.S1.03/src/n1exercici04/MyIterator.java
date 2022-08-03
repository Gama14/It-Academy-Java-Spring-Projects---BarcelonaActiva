package n1exercici04;

import java.util.Comparator;

public class MyIterator implements Comparable<MyIterator> {
	private String name;
	
	MyIterator(String name){
		this.name=name;
	}
	
	public int compareTo(MyIterator o) {
        return this.name.compareTo(o.name);
	}    
	public String toString() {
		return "El nom del personatge es: "+name;
		
	}

	//@Override
	//public int compare(MyIterator o1, MyIterator o2) {
		// TODO Auto-generated method stub
	//	return 0;
	//}


}
