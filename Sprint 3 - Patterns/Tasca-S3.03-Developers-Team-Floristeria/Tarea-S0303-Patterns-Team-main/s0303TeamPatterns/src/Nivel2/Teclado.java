package Nivel2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

    //metodos para ingresar por teclado con validaciones de escritura
    public static double ingresarDouble(String mensaje) {
        Scanner input = new Scanner (System.in);
        double numero = 0.0;
        boolean correcto = false;
        do {
            System.out.println(mensaje);
            try{
                numero = input.nextDouble();
                correcto = true;
            }catch (InputMismatchException ex){
                System.out.println("Error de formato, mire que sean numeros separados por coma");
                input.nextLine();
            }

        }while (!correcto);
        return  numero;
    }
    public static int ingresarInt(String mensaje) {
        Scanner input = new Scanner (System.in);
        int numero = 0;
        boolean correcto = false;
        do {
            System.out.println(mensaje);
            try{
                numero = input.nextInt();
                correcto = true;
            }catch (InputMismatchException ex){
                System.out.println("Error de formato, mire que sean numeros ");
                input.nextLine();
            }
        }while (!correcto);
        return  numero;
    }
    public static String ingresarString(String mensaje) {
        Scanner input = new Scanner (System.in);
        String palabra = "";
        boolean correcto = false;
        do {
            System.out.println(mensaje);
            try{
                palabra = input.nextLine();
                correcto = true;
            }catch (Exception ex){
                System.out.println("Error de formato ");
                input.nextLine();
            }
        }while (!correcto);

        return palabra;
    }

}
