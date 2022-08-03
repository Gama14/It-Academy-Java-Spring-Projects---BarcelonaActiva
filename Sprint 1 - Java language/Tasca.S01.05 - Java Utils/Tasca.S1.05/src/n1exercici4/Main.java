package n1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		String ubicacionArchivo= "D:\\Sara\\Ejercicio 2";
		
		File files= new File (ubicacionArchivo);
		//buscarDirectorio(files);
		String ubicacionArcivo2 = "C:\\Users\\formacio\\Desktop\\ejercicio3.txt";
		lectorArchivo(ubicacionArcivo2);
		
		
	}
	static StringBuffer sb=new StringBuffer(); 
	public static void buscarDirectorio(File files) {
		sb.append(files + "(D)"+"\n"); 
		System.out.println(files + "(D)");
		File[] listaFiles = files.listFiles();
		Arrays.sort(listaFiles);
		
		if (listaFiles!=null) {
			for (File f : listaFiles) {
				if(f.isDirectory()) {
					buscarDirectorio(f);
				}else if(f.isFile()){
					System.out.println(f.getName() + "(F)" + new Date(f.lastModified()));
					sb.append(files + "(F)"+"\n");
				}
			}
		}else {
			System.out.println(files +" (A)");
			sb.append(files + "(A)"+"\n");
		}
		
	}

	public static void lectorArchivo (String ruta) throws FileNotFoundException, IOException{
	
		FileReader lector = new FileReader (ruta);
		BufferedReader br = new BufferedReader (lector);
		String sb;
		while ((sb = br.readLine())!=null) { //rellenamos el almacenador con el buferador
	           System.out.println(sb); //imprimimos por consola el contenido del almacenador 
		}
	    br.close(); //cerramos buferador

		
	}
}
