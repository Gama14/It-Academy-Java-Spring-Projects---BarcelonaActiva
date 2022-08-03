package Nivel2;

public class Arbol extends Articulo {

    //atributos
    private static int id = 1;
    private double altura;

    //contructor
    public Arbol(String nombre, double precio, double altura) {
        this.nombre = nombre;
        this.precio = precio;
        this.altura = altura;
        idArticulo=Arbol.id++;
        tipo= "A";
    }

    //getters
    public double getAltura() {
        return altura;
    }


}
