package n1exercici04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyIterator n1= new MyIterator("Hercules");
		MyIterator n2= new MyIterator("Mulan");
		MyIterator n3= new MyIterator("Elsa");
		
		ArrayList<MyIterator> listaArrayList = new ArrayList<MyIterator>();
		listaArrayList.add(n1);
		listaArrayList.add(n2);
		listaArrayList.add(n3);
		recorrerColollection(listaArrayList);
		
		HashSet<MyIterator> listaHashSet = new HashSet<MyIterator>();
		listaHashSet.add(n1);
		listaHashSet.add(n2);
		listaHashSet.add(n3);
		recorrerColollection(listaHashSet);
		
		TreeSet<MyIterator> listaTreeSet = new TreeSet<MyIterator>();
		listaTreeSet.add(n1);
		listaTreeSet.add(n2);
		listaTreeSet.add(n3);
		recorrerColollection(listaTreeSet);
		
		LinkedList<MyIterator> listaLinked = new LinkedList<MyIterator>();
		listaLinked.add(n1);
		listaLinked.add(n2);
		listaLinked.add(n3);
		recorrerColollection(listaLinked);
		
		LinkedHashSet<MyIterator> listaLinkedHashSet= new LinkedHashSet<MyIterator>();
		listaLinkedHashSet.add(n1);
		listaLinkedHashSet.add(n2);
		listaLinkedHashSet.add(n3);
		recorrerColollection(listaLinkedHashSet);
	}
	//metode que recorre qualsevol collection a traves d'un iterador i imprimeix
	public static void recorrerColollection(Collection<MyIterator> e) {
		Iterator <MyIterator > it = e.iterator();
		while (it.hasNext()) {
		  System.out.println(it.next().toString());
		}
	}
}
