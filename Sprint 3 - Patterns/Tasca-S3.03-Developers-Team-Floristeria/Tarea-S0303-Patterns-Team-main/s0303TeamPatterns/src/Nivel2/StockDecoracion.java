package Nivel2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StockDecoracion extends Stock {

    //contructor vacio
    public StockDecoracion() {
    }

    //metodos de articulos de decoracion
    public void crearArticulo() {
        String nombre = teclado.ingresarString("Nombre Decoración:");
        double precio = teclado.ingresarDouble("Ingrese el precio:");
        String material = teclado.ingresarString("Ingrese el material:");
        dbDecoracion.add(new Decoracion(nombre,precio,material));
        try {
            Statement st = cn.createStatement();
            PreparedStatement miSentencia = cn.prepareStatement("INSERT INTO decoracion (tipo, idArticulo, nombre, precio, material) VALUES(?,?,?,?,?)");
            PreparedStatement miSentencia2 = cn.prepareStatement("INSERT INTO articulos (tipo, idArticulo,nombre, precio) VALUES(?,?,?,?)");
            miSentencia.setString(1, "D");
            miSentencia.setString(2, null);
            miSentencia.setString(3, nombre);
            miSentencia.setString(4, String.valueOf(precio));
            miSentencia.setString(5, material);

            miSentencia2.setString(1, "D");
            miSentencia2.setString(2, null);
            miSentencia2.setString(3, nombre);
            miSentencia2.setString(4, String.valueOf(precio));

            miSentencia2.executeUpdate();
            miSentencia.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
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
        try {
            PreparedStatement miSentencia = cn.prepareStatement("DELETE FROM decoracion  WHERE idArticulo=? ");

            miSentencia.setInt(1, idArticulo);

            miSentencia.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
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
