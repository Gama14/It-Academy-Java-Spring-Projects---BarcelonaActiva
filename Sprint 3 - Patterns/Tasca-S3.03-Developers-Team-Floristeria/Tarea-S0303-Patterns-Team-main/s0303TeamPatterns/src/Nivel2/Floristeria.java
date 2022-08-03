package Nivel2;

import Nivel2.conectaBD_SQL.ConnectionDB_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Floristeria implements IFloristeria {

    //atributos
    private String nombre;
    private Stock stockArbol;
    private Stock stockDecoracion;
    private Stock stockFlor;
    private ArrayList<Ticket> dbTickets;
    public ArrayList<Articulo> ventas;
    private static ConnectionDB_SQL conexion = new ConnectionDB_SQL();
    private static Connection cn = conexion.conectar();


    //instanciamos la clase teclado
    private Teclado teclado= new Teclado();

    //constructor
    public Floristeria(String nombre) {
        this.nombre = nombre;
        stockArbol = new StockArbol();
        stockDecoracion = new StockDecoracion();
        stockFlor = new StockFlor();
        dbTickets = new ArrayList<Ticket>();
        ventas = new ArrayList<Articulo>();
    }

    //getters
    public String getNombre() {
        return nombre;
    } //get del nombre de la floristeria
    public Stock getStock(String nombre){
        Stock s1 = null;
        switch (nombre.toLowerCase()){
            case "a":
                s1= getStockArbol();
                break;
            case "d":
                s1=getStockDecoracion();
                break;
            case "f":
                s1=getStockFlor();
                break;
        }
        return s1;
    }
    public Stock getStockArbol() {
        return stockArbol;
    }
    public Stock getStockDecoracion() {
        return stockDecoracion;
    }
    public Stock getStockFlor() {
        return stockFlor;
    }
    public ArrayList<Ticket> getDbTickets() {
        return dbTickets;
    }

    //Metodos de Stock
    public void imprimirStocks (){
        stockArbol.imprimirStock();
        stockDecoracion.imprimirStock();
        stockFlor.imprimirStock();
    }
    public void mostrarCantidadStock() {
        stockArbol.mostrarCantidadStock();
        stockDecoracion.mostrarCantidadStock();
        stockFlor.mostrarCantidadStock();
    }
    public void sumatoriaValorStock(){
        double sA=  stockArbol.sumatoriaValorStock();
        double sD= stockDecoracion.sumatoriaValorStock();
        double sF= stockFlor.sumatoriaValorStock();
        double total = sA+sD+sF;
        System.out.println("El valor total de los stocks es de: "+ total);
    }

    //Metodos de ticket
    public Ticket crearTicket (){
        Ticket t1 = new Ticket();
        dbTickets.add(t1);
        return t1;
    }
    public void addArtiuclosTicket (Floristeria floristeria) throws SQLException {
        int opcionIngresada = teclado.ingresarInt("Ingresa 1 para añadir un artículo, de lo contrario pulse 0.");
        Ticket t1 = crearTicket();
        int idArticulo;
        String tipoArticulo;

        while(opcionIngresada == 1) {
            tipoArticulo = teclado.ingresarString("Qué tipo de artículo quieres añadir (A,F,D)?");
            idArticulo = teclado.ingresarInt("Cual es el id del artículo que quieres añadir?");
            if(existeArticulo(idArticulo,tipoArticulo)) {
                switch (tipoArticulo.toLowerCase()) {
                    case "a":
                        //añade el articulo al ticket
                        t1.addArticuloAlTicket(floristeria.stockArbol.getArticulo(idArticulo, tipoArticulo));
                        //añade el articulo al array ventas
                        ventas.add(floristeria.stockArbol.getArticulo(idArticulo, tipoArticulo));

                        try {
                            Statement st = cn.createStatement();
                            //añadirá el articulo a la tabla ventas
                            PreparedStatement miSentencia = cn.prepareStatement("INSERT INTO ventas (idTicket, tipoArticulo, idArticulo, nombreArticulo,precioArticulo)" +
                                    " VALUES(?,?,?,?,?)");
                            miSentencia.setString(1, null);
                            miSentencia.setString(2, "A");
                            miSentencia.setString(3, String.valueOf(idArticulo));
                            miSentencia.setString(4, stockArbol.getArticulo(idArticulo, tipoArticulo).getNombre());
                            miSentencia.setString(5,String.valueOf(stockArbol.getArticulo(idArticulo, tipoArticulo).getPrecio()));

                            miSentencia.executeUpdate();

                            stockArbol.eliminarArticulo(idArticulo); //para sacar del stock lo vendido

                        }catch (SQLException e){
                            e.printStackTrace();
                        }

                        break;
                    case "d":
                        t1.addArticuloAlTicket(floristeria.stockDecoracion.getArticulo(idArticulo, tipoArticulo));
                        ventas.add(floristeria.stockDecoracion.getArticulo(idArticulo, tipoArticulo));

                        try {
                            Statement st = cn.createStatement();
                            PreparedStatement miSentencia = cn.prepareStatement("INSERT INTO ventas (idTicket, tipoArticulo, idArticulo, nombreArticulo,precioArticulo)" +
                                    " VALUES(?,?,?,?,?)");
                            miSentencia.setString(1, null);
                            miSentencia.setString(2, "D");
                            miSentencia.setString(3, String.valueOf(idArticulo));
                            miSentencia.setString(4, stockDecoracion.getArticulo(idArticulo, tipoArticulo).getNombre());
                            miSentencia.setString(5, String.valueOf(stockDecoracion.getArticulo(idArticulo, tipoArticulo).getPrecio()));

                            miSentencia.executeUpdate();

                            stockDecoracion.eliminarArticulo(idArticulo);

                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                        break;
                    case "f":
                        t1.addArticuloAlTicket(floristeria.stockFlor.getArticulo(idArticulo, tipoArticulo));
                        ventas.add(floristeria.stockFlor.getArticulo(idArticulo, tipoArticulo));

                        try {
                            Statement st = cn.createStatement();
                            PreparedStatement miSentencia = cn.prepareStatement("INSERT INTO ventas (idTicket, tipoArticulo, idArticulo, nombreArticulo,precioArticulo)" +
                                    " VALUES(?,?,?,?,?)");
                            miSentencia.setString(1, null);
                            miSentencia.setString(2, "F");
                            miSentencia.setString(3, String.valueOf(idArticulo));
                            miSentencia.setString(4, stockFlor.getArticulo(idArticulo, tipoArticulo).getNombre());
                            miSentencia.setString(5, String.valueOf(stockFlor.getArticulo(idArticulo, tipoArticulo).getPrecio()));

                            miSentencia.executeUpdate();

                            stockFlor.eliminarArticulo(idArticulo);

                        }catch (SQLException e){
                            e.printStackTrace();
                        }

                        break;
                }
                opcionIngresada = teclado.ingresarInt("Ingresa 1 para añadir un articulo, de lo contrario pulse 0.");
            }else{
                System.out.println("El articulo no existe en nuestra base de datos");
                opcionIngresada = teclado.ingresarInt("Ingresa 1 para añadir un articulo, de lo contrario pulse 0.");
            }
        }
        t1.imprimirTicket();
    }
    public void mostrarTickets (){
        for (int i = 0; i < dbTickets.size(); i++){
            System.out.println("ID Ticket: "+ dbTickets.get(i).getIDTicket());
            for(int j = 0; j < dbTickets.get(i).listaArticulos.size(); j++){
                System.out.println("ID Articulo: "+ dbTickets.get(i).listaArticulos.get(j).getTipo() + dbTickets.get(i).listaArticulos.get(j).getID() +
                        " / Nombre: "+ dbTickets.get(i).listaArticulos.get(j).getNombre() + " / Precio: €" + dbTickets.get(i).listaArticulos.get(j).getPrecio());
            }
        }
    }

    //Metodo de venta
    public void mostrarSumatorioVentas(){
        double valorTotalVentas = 0;
        for(int i = 0; i < ventas.size(); i++){
            valorTotalVentas += ventas.get(i).getPrecio();
        }
        System.out.println("El valor total de las ventas es: €" +  valorTotalVentas);
    }

    //verificaciones
    public boolean existeArticulo (int idArticulo,String tipoArticulo) {
        boolean existeArticulo = false;
        switch (tipoArticulo.toLowerCase()) {
            case "a":
                for (int i = 0; i < stockArbol.dbArbol.size(); i++) {
                    if (idArticulo == stockArbol.dbArbol.get(i).getID()) {
                        existeArticulo = true;
                    }
                }
                break;
            case "d":
                for (int i = 0; i < stockDecoracion.dbDecoracion.size(); i++) {
                    if (idArticulo == stockDecoracion.dbDecoracion.get(i).getID()) {
                        existeArticulo = true;
                    }
                }
                break;
            case "f":
                for (int i = 0; i < stockFlor.dbFlor.size(); i++) {
                    if (idArticulo == stockFlor.dbFlor.get(i).getID()) {
                        existeArticulo = true;
                    }
                break;
                }
        }
        return existeArticulo;
    }

}


