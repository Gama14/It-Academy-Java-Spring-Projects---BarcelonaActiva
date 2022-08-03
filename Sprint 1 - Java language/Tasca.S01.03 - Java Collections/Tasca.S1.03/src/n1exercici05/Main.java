package n1exercici05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main (String []args) {

    List <Integer> llista1 = new ArrayList <Integer>();
    List <Integer> llista2 = new ArrayList <Integer>();


    for (int i=1; i<=10;i++ ) { //afegeixo deu int a la llista del 1-10
    llista1.add(i);
    }


    /*int index = llista1.size();
    for (int i=index; i>0;i--) {
        llista2.add(llista1.get(i-1)); --> altres maneres d'inserir els elements de manera inversa
    }
    for (Integer i:llista1) {
        llista2.add(i-1,index);
        index--;
    }*/
    afegir1(llista1,llista2);
    System.out.println(llista2);

    }
     //tambe es podria utilitzar el metode hasNext i el add(index,int) per invertir la List
    public static void afegir1(List<Integer> llista1,List<Integer> llista2) {
        int index = llista1.size();
        ListIterator<Integer>lit = llista1.listIterator(index);
        while (lit.hasPrevious()) {
            llista2.add(lit.previous());

        }
    }

}