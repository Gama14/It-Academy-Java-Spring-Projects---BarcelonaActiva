package n1exercici2;

import java.io.File;
import java.io.FileFilter;
import java.sql.Date;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ubicacionArchivo= "D:\\Sara\\Ejercicio 2";
		
		File files= new File (ubicacionArchivo);
		buscarDirectorio(files);
		
	}
	public static void buscarDirectorio(File files) { 
		System.out.println(files + "(D)"); //imprimimos el nombre del archivo al cual hemos accedido
		File[] listaFiles = files.listFiles(); // hacemos un array que contiene todos los files del archivo
		Arrays.sort(listaFiles); //los ordenamos alfabeticamente
		
		if (listaFiles!=null) { 
			for (File f : listaFiles) {
				if(f.isDirectory()) { // si el archivo es un directorio, entraremos en él y volveremos a buscar en sus archivos (recursivamente)
					buscarDirectorio(f);
				}else if(f.isFile()){// si el archivo es un file, lo imprimimos con su fecha de ùltima modificación
					System.out.println(f.getName() + "(F)" + new Date(f.lastModified()));
					
				}
			}
		}else {
			System.out.println(files +" (A)");
		}
		
	}

}
