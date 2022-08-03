package jUnit;

public class ArrayIndexOutOfBounds {

	private int [] llistaNum = {1,2,3,4};

	public int[] getLlistaNum() {
		return llistaNum;
	}

	public void setLlistaNum(int[] llistaNum) {
		this.llistaNum = llistaNum;
	}

	public int getIndex (int index) {
		return llistaNum [index];
	}
	
	

}
