package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ubicacionArchivo= "D:\\Sara\\Ejercicio 2"; //ponemos la ruta del archivo al que queremos acceder
		
		File doc1 = new File (ubicacionArchivo); //creamos un objeto file con la ruta que hemos elegido
		String [] lista = doc1.list(); 
		//hacemos una lista de strings con el nombre de los archivos y los ordenamos
		
		Arrays.sort(lista);
		
		for (String elemento:lista) {
			System.out.println(elemento); //imprimimos los elementos de la lista
		}
	}

}
