package n2exercici01;

public class Numero implements Comparable<Numero> {
	private int numRandom;
	Numero (){
		numRandom =  (int) Math.ceil(Math.random()*100);
	}

	public int getNumRandom() {
		return numRandom;
	}
	public void setNumRandom(int numRandom) {
		this.numRandom = numRandom;
	}

	@Override
	public int compareTo(Numero o) {
		 if (numRandom < o.getNumRandom()) {
	            return 1;
	     } else if (numRandom > o.getNumRandom()) {
	            return -1;
	     } else {
	            return 0;
	     }
	   
		
	}
}
