package n1exercici03;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Generadora>list=new ArrayList <Generadora>();
		Generadora per1= new Generadora ("Tarzan");
		Generadora per2= new Generadora ("Mulan");
		Generadora per3= new Generadora ("Elsa");
		Generadora per4= new Generadora ("Simba");
		Generadora per5= new Generadora ("Hercules");
	
		list.add(per1);
		list.add(per2);
		list.add(per3);
		list.add(per4);
		list.add(per5);
		int index= 2;
		
		for (int i=0; i<list.size();i++) {
			index+=1;	
			if (index==list.size()) {
				index=0;
			}
			System.out.println(nextPersonatge(index,list));
		}
	
	}
	public static String nextPersonatge (int index, ArrayList <Generadora> list) {

		return list.get(index).getPersonatge();
	}	
	
}
