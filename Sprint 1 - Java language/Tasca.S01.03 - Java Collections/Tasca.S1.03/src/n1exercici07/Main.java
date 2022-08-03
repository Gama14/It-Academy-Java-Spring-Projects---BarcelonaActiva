package n1exercici07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		HashMap <String,String> capitalCity = new HashMap <String,String>();
		capitalCity.put("England","London");
		capitalCity.put("Germany","Berlin");
		capitalCity.put("Norwey","Oslo");
		capitalCity.put("USA","Washington DC");
		capitalCity.put("Spain","Madrid");
		System.out.println(capitalCity); //s'imprimeix en un ordre
		
		TreeMap<String,String> capitalCityTreeMap=new TreeMap<String,String>(); 
		capitalCityTreeMap.putAll(capitalCity);
		System.out.println(capitalCityTreeMap); //s'imprimeix per ordre alfabetic
		
		LinkedHashMap <String,String> capitalCityLinkedHashMap=new LinkedHashMap<String,String>(capitalCityTreeMap); 
		System.out.println(capitalCityLinkedHashMap);//es manté l'ordre d'impresió
		
		HashSet <String> country = new HashSet <String>();
		country.addAll(capitalCityLinkedHashMap.keySet());
		System.out.println(country); //l'ordre de les claus varia al introduir-lo al HashSet, es el mateix que el del Hash Map
		
		LinkedHashSet <String> countryLinkedHashSet = new LinkedHashSet <String>();
		countryLinkedHashSet.addAll(capitalCityLinkedHashMap.keySet());
		System.out.println(countryLinkedHashSet);//Aqui si que es manté l'orde
	
	}
}
