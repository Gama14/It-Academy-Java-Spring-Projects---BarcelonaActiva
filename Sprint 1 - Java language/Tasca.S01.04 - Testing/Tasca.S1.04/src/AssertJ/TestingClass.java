package AssertJ;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestingClass {

		//Ejercicio 1
		@Test
		void testIsEqual() {
			int num1 =2;
			int num2= 2;
			assertThat(num1).isEqualTo(num2);
			assertThat(num1+1).isNotEqualTo(num2);
		}
		
		//Ejercicio 2
		@Test
		void testObjectisEqual() {
			String nom1 = "Alba";
			String nom2 = "Alba";
			String nom3= "Pepe";
			assertThat(nom1).isEqualTo(nom2);
			assertThat(nom1).isNotEqualTo(nom3);
		}
	
		//Ejercicio 3
		@Test
		void testArray() {
			int [] llista1 = {1,2,3,4,5};
			int [] llista2 = {1,2,3,4,5};
			assertThat(llista1).isEqualTo (llista2);
		}
		
		//Ejercicio 4
		@Test
		void testArrayList () {
			ArrayList<Object> llista = new ArrayList <Object> ();
			Persona p1 = new Persona("Marcos",23);
			Persona p2 = new Persona("Pablo",22);
			llista.add(p1);
			llista.add(p2);
			llista.add(p1);
			Animal a1 = new Animal( "Tigre");
			llista.add(a1);
			Animal a2 = new Animal( "Pantera");
			assertThat(llista).containsExactly(p1,p2,p1,a1);
			assertThat(llista).containsOnlyOnce(llista.get(1));
			assertThat(llista).doesNotContain(a2);
			
		}
		
		//Ejercicio 5
		 @Test
		 void testMap() {
			 Map <Integer,String> m1 = new HashMap <Integer,String>();
			 m1.put(1, "Alba");
			 m1.put(2, "Pepe");
			 assertThat(m1).containsKey(1);
			 
		 }
		 //Ejercicio 6
		 @Test
		 void testArrayOutOfBounds() {
			 ArrayList<Integer> llista =  new ArrayList<Integer>();
			 llista.add(1);
			 assertThatExceptionOfType(IndexOutOfBoundsException.class)
			  .isThrownBy(() -> {
			   llista.get(2);
			});
		 }
		 
		 //Ejercicio 7
		 @Test
		 void testObjectNull() {
			 String optional= "";
			 assertThat(optional).isEmpty();
		 }
}
