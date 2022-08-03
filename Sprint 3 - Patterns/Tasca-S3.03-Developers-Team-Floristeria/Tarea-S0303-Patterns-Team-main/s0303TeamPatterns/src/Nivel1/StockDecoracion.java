package Nivel1;

public class StockDecoracion extends Stock{

    //contructor vacio
    public StockDecoracion() {
    }

    //metodos de articulos de decoracion
    public void crearArticulo() {
        String nombre = teclado.ingresarString("Nombre Decoración:");
        double precio = teclado.ingresarDouble("Ingrese el precio:");
        String material = teclado.ingresarString("Ingrese el material:");
        dbDecoracion.add(new Decoracion (nombre,precio,material));
    }
    public void eliminarArticulo(int idArticulo) {
        int i = 0;
        while (i<dbDecoracion.size()){
            if (idArticulo == dbDecoracion.get(i).getID()){
                dbDecoracion.remove(i);

            } else {
                i++;
            }
        }
    }

    //metodos de stock de decoracion
    public void imprimirStock() {
        dbDecoracion.forEach(x->System.out.println("ID: D"+x.getID()+" / Nombre: "+x.getNombre()+" / Precio: €"+x.getPrecio()+" / Material: "+x.getMaterial()));
    }
    public void mostrarCantidadStock() {
        System.out.println("Stock Decoración: " + dbDecoracion.size());
    }
    public double sumatoriaValorStock(){
        double valorTotalDecoracion = 0;

        for (int i = 0; i < dbDecoracion.size() ; i++){
            valorTotalDecoracion += dbDecoracion.get(i).getPrecio();
        }

        return valorTotalDecoracion;
    }

}
