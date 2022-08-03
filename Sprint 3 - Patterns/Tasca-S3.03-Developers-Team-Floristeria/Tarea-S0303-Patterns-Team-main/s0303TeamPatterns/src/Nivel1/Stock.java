package Nivel1;



import java.util.ArrayList;

public class Stock {

    //intanciamos cada bd y la clase teclado
    protected ArrayList<Arbol> dbArbol = new ArrayList<Arbol>();
    protected ArrayList<Flor> dbFlor= new  ArrayList<Flor>();
    protected ArrayList<Decoracion> dbDecoracion = new ArrayList<Decoracion>();
    protected Teclado teclado = new Teclado();

    //contructor vacio
    public Stock (){

    }

    //getter
    public Articulo getArticulo (int idArticulo, String tipo){
        Articulo articulo = null;

        switch (tipo.toLowerCase()){
            case "a":
                for (int i = 0; i < dbArbol.size(); i++){
                    if(dbArbol.get(i).getID() == idArticulo);
                    articulo = dbArbol.get(i);
                }
                break;
            case "d":
                for (int i = 0; i < dbDecoracion.size(); i++){
                    if(dbDecoracion.get(i).getID() == idArticulo);
                    articulo= dbDecoracion.get(i);
                }
                break;
            case "f":
                for (int i = 0; i < dbFlor.size(); i++){
                    if(dbFlor.get(i).getID() == idArticulo);
                    articulo = dbFlor.get(i);
                }
                break;
        }
        return articulo;
    }

    //metodos de articulo
    public void crearArticulo(){
    }
    public void eliminarArticulo(int idArticulo){
    }

    //metodos de stock
    public void imprimirStock(){
    }
    public void mostrarCantidadStock(){
    }
    public double sumatoriaValorStock(){
        return 0;
    }

}
