package Nivel1;

import java.util.ArrayList;

public class Ticket {

    //atributos
    private static int id = 0;
    private  int idTicket;
    //instancia de la lista de articulos
    public ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();

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
    public void addArticuloAlTicket (Articulo articulo){
        listaArticulos.add(articulo);
    }
    public void imprimirTicket(){
        listaArticulos.forEach(x->System.out.println("ID: "+x.getTipo()+x.getID()+" / Nombre: "+x.getNombre()+" / Precio: €"+x.getPrecio()));
    }

    //metodos de compra-venta
    public void mostrarCompra(){
        listaArticulos.forEach(x-> System.out.println("ID: " + x.getTipo() +x.getID()+" / Nombre: "+x.getNombre()+" / "+x.getPrecio()));
    }
    public double totalPrecioTicket(){
        double totalVentas=0;
        for(int i=0;i<listaArticulos.size();i++){
            totalVentas+= listaArticulos.get(i).getPrecio();
        }
       return Math.round(totalVentas*100d)/100d;
    }

}
