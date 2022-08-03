package Nivel1;

public class Articulo {

    //atributos
    protected static int id = 0;
    protected int idArticulo;
    protected String nombre;
    protected double precio;
    protected String tipo;

    //contructor vacio
    public Articulo() {
    }

    //getters
    public int getID() {
        return idArticulo;
    }
    public double getPrecio() {
        return precio;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
