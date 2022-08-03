package Nivel1;

import java.util.ArrayList;

public class Floristeria implements IFloristeria {

    //atributos
    private String nombre;
    private Stock stockArbol;
    private Stock stockDecoracion;
    private Stock stockFlor;
    private ArrayList<Ticket> dbTickets;
    public ArrayList<Articulo> ventas;

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
        stockArbol.imprimirStock();  //recursividad
        stockDecoracion.imprimirStock();
        stockFlor.imprimirStock();
    }
    public void mostrarCantidadStock() {
        stockArbol.mostrarCantidadStock();  //recursividad
        stockDecoracion.mostrarCantidadStock();
        stockFlor.mostrarCantidadStock();
    }
    public void sumatoriaValorStock(){
        double sA=  stockArbol.sumatoriaValorStock();  //recursividad
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
    public void addArtiuclosTicket (Floristeria floristeria){
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
                        t1.addArticuloAlTicket(floristeria.stockArbol.getArticulo(idArticulo, tipoArticulo));
                        ventas.add(floristeria.stockArbol.getArticulo(idArticulo, tipoArticulo));
                        stockArbol.eliminarArticulo(idArticulo); //para sacar del stock lo vendido
                        break;
                    case "d":
                        t1.addArticuloAlTicket(floristeria.stockDecoracion.getArticulo(idArticulo, tipoArticulo));
                        ventas.add(floristeria.stockDecoracion.getArticulo(idArticulo, tipoArticulo));
                        stockDecoracion.eliminarArticulo(idArticulo);
                        break;
                    case "f":
                        t1.addArticuloAlTicket(floristeria.stockFlor.getArticulo(idArticulo, tipoArticulo));
                        ventas.add(floristeria.stockFlor.getArticulo(idArticulo, tipoArticulo));
                        stockFlor.eliminarArticulo(idArticulo);
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


