package n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ubicacionArchivo= "D:\\Sara\\Ejercicio 2";
		
		File files= new File (ubicacionArchivo);
		buscarDirectorio(files);
		try {
			FileWriter fw = new FileWriter((new File("C:\\Users\\formacio\\Desktop\\ejercicio3.txt"))); 
			//se crea con la ruta donde se creara el nuevo archivo de texto
			fw.append(sb.toString());//se escribirá el contenido del parametro
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	static StringBuffer sb=new StringBuffer(); //se crea para almacenar cadenas de string modificbles
	public static void buscarDirectorio(File files) {
		sb.append(files + "(D)"+"\n"); // añade el contenido del parametro como si fuera un conjunto de strings
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

}
