package n1exercici08;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		LinkedHashMap<String,Persona> persones = new LinkedHashMap<String,Persona>();
		Persona p1 = new Persona ("Eva");
		Persona p2 = new Persona ("Carlos");
		Persona p3 = new Persona ("Jorge");
		Persona p4 = new Persona ("Maria");
		
		persones.put("e", p1);
		persones.put("c", p2);
		persones.put("j", p3);
		persones.put("m", p4);
		
	//	System.out.println(persones.keySet() + persones.values().toString());
		
		Set<Map.Entry<String,Persona>> listaSet = persones.entrySet();
		ArrayList<Map.Entry<String,Persona>> listaPers = new  ArrayList<Map.Entry<String,Persona>>(listaSet);
		
		 Collections.sort(listaPers, new Comparator<Map.Entry<String,Persona>>(){
             public int compare(Map.Entry<String,Persona> entry1, Map.Entry<String,Persona> entry2) {
                 return entry1.getKey().compareTo(entry2.getKey());
             }
        });
		
		System.out.println(listaPers);
		
		LinkedHashMap<String,Persona> persones2 = new LinkedHashMap<String,Persona>();
		
         for (Map.Entry<String,Persona> entry : listaPers) {  
        	 persones2.put(entry.getKey(), entry.getValue()); 
         }

    	System.out.println(persones2);
		
		/*ArrayList <String> ordreAlfKey = new ArrayList <String> ();
		ordreAlfKey.addAll(persones.keySet());
		Collections.sort(ordreAlfKey);
		System.out.println(ordreAlfKey);*/
		
		/*ArrayList <Persona> ordreVal = new ArrayList <Persona> ();
		ordreVal.addAll(persones.values());
		
		Collections.sort(ordreVal, new Comparator<Persona>() {
			   public int compare(Persona p1, Persona p2) {
			      return p1.getName().compareTo(p2.getName());
			   }
			});
		System.out.println(ordreVal);*/
		
		/*Comparator<Persona> comparator = new Comparator<>(){
		    public int compare(Persona object1, Persona object2){
		         //Como string tiene ya un comparator definido
		         return object1.getName().compareTo(object2.getName());
		    }
		};*/
		
	}

}
