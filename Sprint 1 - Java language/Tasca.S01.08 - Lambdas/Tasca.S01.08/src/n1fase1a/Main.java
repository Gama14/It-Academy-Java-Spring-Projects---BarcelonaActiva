package n1fase1a;
/*
 * Teniendo  una lista de  cadenas  de  nombres  propios ,  escribe  un  método  que devuelve 
 * una lista de todas las  cadenas  que  comienzan con  la  letra  'a' ( mayuscula ) y  
 * tienen exactamente  3  letras . Imprime el  resultado .      
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[]args) {
		ArrayList<String> namesAL = new ArrayList<String>();
		namesAL.add("Sara");
		namesAL.add("Ana");
		namesAL.add("Carlos");
		namesAL.add("Ava");
		namesAL.add("Ada");
		namesAL.add("Pedro");
		namesAL.add("Noe");
		namesAL.add("Marcos");
		
		System.out.println("ArrayList: "+aAnd3(namesAL));
		
		List<String> namesList = Arrays.asList("Sara","Ana","Carlos","Ava","Ada","Pedro","Noe","Marcos");
		
		System.out.println("Original name list: "+namesList);
		
		List<String> a3names = namesList.stream()
				.filter(n -> n.startsWith("A") && n.length() == 3)
				.collect(Collectors.toList());
		
		System.out.println("\nNames starting whit \"A\" and 3 letters: "+a3names);
		
	}

	private static List<String> aAnd3(List<String> names) {
		//.stream().filter  ---> lo usamos para filtrar solo los nombres que empiecen con A y tengan 3 letras
		List<String> aAnd3selected = names.stream()
				.filter(n -> n.startsWith("A") && n.length() == 3)
				.collect(Collectors.toList()); //recopila en una nueva lista los elementos extraidos
		return aAnd3selected;
	}
	
	
}