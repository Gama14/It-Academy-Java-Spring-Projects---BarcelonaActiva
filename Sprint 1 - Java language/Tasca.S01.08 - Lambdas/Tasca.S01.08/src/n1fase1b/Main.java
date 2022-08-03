package n1fase1b;
/*
 * Escribe un método que retorne una cadena separada por comas basada en una lista de Integers. 
 * Cada elemento tendrá que ir precedido per la letra "e" si el nombre es par, 
 * y precedido de la letra "o" si el nombre es impar. Por ejemplo, si la lista de entrada es (3,44), 
 * la salida tendrá que ser "o3, e44". 
 * Imprime el resultado
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[]args) {
		
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		numbersList.add(14);
		numbersList.add(23);
		numbersList.add(76);
		numbersList.add(55);
		System.out.println("ArrayList original: "+numbersList);
		
		System.out.println("Lista diferenciando par e impar: "+ parImpar(numbersList));
		
		//convertir lista de nuemeros a una lista de String indicando si es par o impar
		// con esta manera
		List<Integer> numbers = Arrays.asList(14,23,76,55);
		System.out.println("Lista original: "+numbers);
		
		List<String> modifiedNumbers = numbers.stream()
				.map(n -> n % 2 == 0 ? ("e"+n) : ("o"+n)) //Map dentro de un stream convierte un tipo de objeto en otro, o trabajar con el objeto que hemos recibido
				.collect(Collectors.toList());   //recolectar los elementos en una lista
		String modifiedToString = modifiedNumbers.stream().map(mN -> mN.toString())
				.collect(Collectors.joining(", "));//permite recoger una lista de valores y convertirlos en una cadena asignando delimitadores
		
		System.out.println("Lista de numeros modificados indicando par e impar: "+modifiedToString);
		
		
	}
	//con esta funcion se ordenan todos los pares juntos y luego los impares juntos
	public static String parImpar (ArrayList<Integer> numbersList) {
		String par = numbersList.stream()
				.filter(n -> n%2 ==0).map(n -> "e" + n)
				.collect(Collectors.joining(","));
		String impar = numbersList.stream()
				.filter(n -> n%2 !=0).map(n -> "o" + n)
				.collect(Collectors.joining(","));
		return par +","+ impar;
	}
}