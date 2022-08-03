package Nivel2;

import Nivel2.conectaBD_SQL.ConnectionDB_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ticket {

    //atributos
    private static int id = 1;
    private  int idTicket;
    //instancia de la lista de articulos
    public ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    private static ConnectionDB_SQL conexion = new ConnectionDB_SQL();
    private static Connection cn = conexion.conectar();

    //contructor en donde aumenta el id del ticket
    Ticket(){
        idTicket = Ticket.id++;
    }

    //getters
    public ArrayList<Articulo> getTicket (){
        return listaArticulos;
    }
    public  int getIDTicket (){
        return idTicket;
    }

    //metodos de tickets
    public void addArticuloAlTicket (Articulo articulo) throws SQLException{
        listaArticulos.add(articulo);

    }
    public void imprimirTicket(){
        listaArticulos.forEach(x->System.out.println("ID: "+x.getTipo()+x.getID()+" / Nombre: "+x.getNombre()+" / Precio: €"+x.getPrecio()));
        System.out.println("Precio total: " + totalPrecioTicket()+ " €");
    }
    public double totalPrecioTicket(){
        double totalVentas=0;
        for(int i=0;i<listaArticulos.size();i++){
            totalVentas+= listaArticulos.get(i).getPrecio();
        }
       return Math.round(totalVentas*100d)/100d;
    }

}
