package n1fase1e;
/*
 * Cree una  lista  con el número de meses  del  año .
 *  Imprim todos los elementos  de la lista  con  una lambda.            
 */

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> months = Arrays.asList("Ene","Feb","Marzo","Abr",
				"Mayo","Jun","Jul","Agos","Sept","Oct","Nov","Dic");
		System.out.println("Meses: ");
		months.forEach(m -> System.out.println(m));
	}

}