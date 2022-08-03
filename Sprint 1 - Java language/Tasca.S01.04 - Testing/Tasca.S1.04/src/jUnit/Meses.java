package jUnit;

import java.util.ArrayList;

public class Meses {
	private ArrayList<String> meses = new ArrayList <String>();
	Meses (){
		meses.add("1.Enero");
		meses.add("2.Febrero");
		meses.add("3.Marzo");
		meses.add("4.Abril");
		meses.add("5.Mayo");
		meses.add("6.Junio");
		meses.add("7.Julio");
		meses.add("8.Agosto");
		meses.add("9.Septiembre");
		meses.add("10.Octubre");
		meses.add("11.Noviembre");
		meses.add("12.Diciembre");
	}
	
	public int getSize() {
		return meses.size();
	}
	
	public String getPosition(int pos) {
		return meses.get(pos);
	}
}
