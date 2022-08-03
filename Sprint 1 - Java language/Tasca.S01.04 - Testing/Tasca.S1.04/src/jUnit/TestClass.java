package jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClass {
		
	//Ejercicio 1
	@Test  //junit5
	void testLongitud() {
		Meses listaMeses = new Meses();
		assertEquals(listaMeses.getSize(),12);
	}
	
	@Test  //junit5
	void testNotNull() {
		Meses listaMeses = new Meses();
		assertNotNull(listaMeses);
	}
	
	@Test  //junit5
	void testAgosto() {
		Meses listaMeses = new Meses();
		assertTrue(listaMeses.getPosition(7).equalsIgnoreCase("8.Agosto"));
	}
	
	//Ejercicio 2
	
	@Test //junit5
	void testCalculoDni() {
		CalculoDni letraDni = new CalculoDni (48669636);
		assertEquals(letraDni.getLetra(),"V");
	}
	
	//Ejercicio 3
	
	@Test
	void testArrayIndexOutOfBounds() {
		ArrayIndexOutOfBounds llista = new ArrayIndexOutOfBounds ();
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			llista.getIndex(10);	
			
		});
		/*boolean thrown =false;
		try {
			llista.getIndex(10);
		}catch(ArrayIndexOutOfBoundsException e) {
			thrown= true;
		}
		assertTrue(thrown);*/
		      
	}
	
	
}
