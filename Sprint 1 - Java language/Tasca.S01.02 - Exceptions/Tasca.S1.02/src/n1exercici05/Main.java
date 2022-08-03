package n1exercici05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int contador = 0;
		
		
		while(contador<5) {
			try {
				int numUsuari =numUsuari ("Introdueix un numero");
				System.out.println("Numero "+ (contador+1)+ ": "+ numUsuari);
				contador++;
			}catch(Exception e) {
				System.out.println("No es un numero");
				
			}
		}
		System.out.println("S'ha acabat el bucle");

	}
	public static int numUsuari (String missatge) {
		System.out.println(missatge); 
		Scanner input = new Scanner (System.in);
		int numUsuari = input.nextInt();
		return numUsuari;
	}
}
