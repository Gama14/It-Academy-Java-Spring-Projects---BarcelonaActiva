package Nivel1;

public class StockArbol extends Stock {

    //contrucor vacio
    public StockArbol() {
    }

    //metodos de articulos de arbol
    public void crearArticulo() {
        String nombre = teclado.ingresarString("Nombre Arbol:");
        double precio = teclado.ingresarDouble("Ingrese el precio:");
        double altura = teclado.ingresarDouble("Ingrese la altura:");
        dbArbol.add(new Arbol(nombre, precio, altura)); //inyeccion de  dependencia

    }
    public void eliminarArticulo(int idArticulo) {
        int i = 0;
        while (i < dbArbol.size()) {
            if (idArticulo == dbArbol.get(i).getID()) {
                dbArbol.remove(i);
            } else {
                i++;
            }
        }
    }

    //metodos de stock de arbol
    public void imprimirStock() {
        dbArbol.forEach(x -> System.out.println("ID: A" + x.getID() + " / Nombre: " + x.getNombre() + " / Precio: €" + x.getPrecio() + " / Altura: " + x.getAltura() + "mts."));

    }
    public void mostrarCantidadStock() {
        System.out.println("Stock Árboles: " + dbArbol.size());

    }
    public double sumatoriaValorStock(){
        double valorTotalArboles = 0;
        for (int i = 0; i < dbArbol.size() ; i++){
            valorTotalArboles += dbArbol.get(i).getPrecio();
        }
        return valorTotalArboles;
    }

}
