package Nivel1;

public class Flor extends Articulo{

    //atributos
    private static int id = 0;
    private String color;

    //contructor
    public Flor(String nombre, double precio, String color) {
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
        idArticulo = Flor.id++;
        tipo= "F";
    }

    //getters
    public String getColor() {
        return color;
    }
}
