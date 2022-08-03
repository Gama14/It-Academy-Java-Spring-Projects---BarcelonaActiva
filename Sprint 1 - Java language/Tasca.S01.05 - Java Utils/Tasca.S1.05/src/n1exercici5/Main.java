package n1exercici5;
import java.io.*;
import java.util.Date;
public class Main { 
	 public static void main(String[] args) {
		 //Serializar
		 try {
	         FileOutputStream fos = new FileOutputStream("fichero.ser");
	         ObjectOutputStream sos = new ObjectOutputStream(fos);
	         sos.writeObject("Fecha actual");
	         sos.writeObject(new Date());
	         sos.close();
	     }
	     catch (FileNotFoundException ex) {
	         ex.printStackTrace();
	     }
	     catch (IOException ex) {
	         ex.printStackTrace();
	     }
		 
		 //Deserializar
		 try {
	         FileInputStream fis = new FileInputStream("fichero.ser");
	         ObjectInputStream sis = new ObjectInputStream(fis);
	         System.out.println((String)sis.readObject());
	         System.out.println((Date)sis.readObject());
	         sis.close();
	      }
	      catch (FileNotFoundException ex) {
	         ex.printStackTrace();
	      }
	      catch (IOException ex) {
	         ex.printStackTrace();
	      }
	      catch(ClassNotFoundException ex) {
	         ex.printStackTrace();
	      }
	    
	 }
	
}
