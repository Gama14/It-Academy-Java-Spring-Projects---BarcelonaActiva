package Nivel2;

public class Decoracion extends Articulo {

    //atributos
	private static int id = 1;
    private String material;

    //contructor
    public Decoracion(String nombre, double precio, String material) {
        this.nombre = nombre;
        this.precio = precio;
        this.material = material;
        idArticulo = Decoracion.id++;
        tipo = "D";
    }

    //getters
    public String getMaterial() {
        return material;
    }


}



