package Nivel1;

import java.util.ArrayList;

public class AppMenu {

    //instanciamos la bd de floristerias y la clase teclado
    private static ArrayList<Floristeria> dbFloristerias = new ArrayList <Floristeria> ();
    Teclado teclado = new Teclado();

    //metodos de menu
    public int mostrarMenu() {
        int opcionElegida;

            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. crear floristeria.");
            System.out.println("2. crear artículo y añadirlo al stock.");
            System.out.println("3. Eliminar articulo.");
            System.out.println("4. imprimir stock.");
            System.out.println("5. imprimir cantidades stock.");
            System.out.println("6. crear ticket y mostrarlo.");
            System.out.println("7. mostrar todos los tickets.");
            System.out.println("8. Valor total de los Stocks actual.");
            System.out.println("9. Valor total de las ventas");

            System.out.println("0. Salir de la aplicación.\n");

            opcionElegida = teclado.ingresarInt("Escoge una opción del 0 al 8: ");

        return opcionElegida;
    }
    public void realizarOpcionMenu() {
        boolean salir = false;
        String floristeria = "";
        String tipoArticulo;
        do{
            switch(mostrarMenu()) {
                case 1:
                    //crear floristeria
                    String nombre = teclado.ingresarString("Cuál es el nombre de la floristería:");
                    crearFloristeria(nombre);
                    break;
                case 2:
                    //crear artículo y añadirlo al stock
                   floristeria = teclado.ingresarString("En que floristería quieres realizar la acción?");
                   if (existeFloristeria(floristeria)){ //comprueba que existe la floristeria
                       tipoArticulo=teclado.ingresarString("Que tipo de artículo quieres añadir (A,F,D):");
                       if (tipoLetra(tipoArticulo)){ //comprueba que la letra ingresada es correcta
                           getFloristeriaMenu(floristeria).getStock(tipoArticulo).crearArticulo(); //crea y añade al stock un articulo
                           msjArticuloCreado();
                       }else{
                           msjLetraErronea();
                       }
                   }else{
                       msjNoExiste();
                   }
                   break;
                case 3:
                    //eliminar artículo
                    floristeria = teclado.ingresarString("En que floristería quieres realizar la acción?");
                    if (existeFloristeria(floristeria)){ //comprueba que existe la floristeria
                        tipoArticulo=teclado.ingresarString("Que tipo de artículo quieres añadir (A,F,D):");
                        if (tipoLetra(tipoArticulo)){ //comprueba que la letra ingresada es correcta
                            getFloristeriaMenu(floristeria).getStock(tipoArticulo).eliminarArticulo(teclado.ingresarInt("Ingrese el id del artículo:")); //elimina del stock un articulo
                            msjArticuloEliminado();
                        }else{
                            msjLetraErronea();
                        }
                    }else{
                        msjNoExiste();
                    }
                    break;
                case 4:
                    //imprimir stock
                    floristeria = teclado.ingresarString("En que floristería quieres realizar la acción?");
                    if (existeFloristeria(floristeria)){
                        getFloristeriaMenu(floristeria).imprimirStocks();
                    }
                   break;
                case 5:
                    //imprimir cantidades de stock
                    floristeria = teclado.ingresarString("En que floristería quieres realizar la acción?");
                    if (existeFloristeria(floristeria)){
                        getFloristeriaMenu(floristeria).mostrarCantidadStock();
                    }
                    break;
                case 6 :
                    //crear ticket y mostrarlo
                    floristeria = teclado.ingresarString("En que floristería quieres realizar la acción?");
                    Floristeria floristeria1;
                    if (existeFloristeria(floristeria)){
                        floristeria1=getFloristeriaMenu(floristeria);
                        floristeria1.addArtiuclosTicket(floristeria1);
                    }
                    break;
                case 7 :
                    //mostrar todos los tickets
                    floristeria = teclado.ingresarString("En que floristeria quieres realizar la acción?");
                    if (existeFloristeria(floristeria)){
                        getFloristeriaMenu(floristeria).mostrarTickets();
                    }
                    break;
                case 8 :
                    //valor total del stock anual
                    floristeria = teclado.ingresarString("En que floristeria quieres realizar la acción?");
                    if (existeFloristeria(floristeria)){
                        getFloristeriaMenu(floristeria).sumatoriaValorStock();
                    }
                    break;
                case 9 :
                    //valor total de las ventas
                    floristeria = teclado.ingresarString("En que floristeria quieres realizar la acción?");
                    if (existeFloristeria(floristeria)){
                        getFloristeriaMenu(floristeria).mostrarSumatorioVentas();
                    }
                    break;
                case 0 :
                    //salir de app
                    salir=true;
                    break;
                default:
                    System.out.println("Escoge una opcion válida.");
            }
        }while (!salir);
    }

    //metodo para crear floristeria
    public static void crearFloristeria(String nombre) {
        if (dbFloristerias.isEmpty()) {
            dbFloristerias.add(new Floristeria(nombre));
        }else if (!existeFloristeria(nombre)) {
            dbFloristerias.add(new Floristeria(nombre));
        }else{
            System.out.println("La floristeria ya existe");
        }
    }

    // COMPROBACIONES
    static boolean existeFloristeria(String nombre) {
        boolean floristeriaEnApp = false;
        int indice=0;

        while((floristeriaEnApp == false) && (indice < dbFloristerias.size())) {
            if(nombre.equalsIgnoreCase(dbFloristerias.get(indice).getNombre())){
                floristeriaEnApp = true;
            } else {
                indice ++;
            }
        }

        return floristeriaEnApp;
    }
    static Floristeria getFloristeriaMenu(String nombre){
        int i = 0;
        Floristeria f1= null;
        while (i<dbFloristerias.size()&& i>=0) {
            if (nombre.equalsIgnoreCase(dbFloristerias.get(i).getNombre())) {
                f1 = dbFloristerias.get(i);
                i=-1;
            } else {
                i++;
            }
        }
        return f1;
    }
    static boolean tipoLetra (String nombre){
       boolean letraAdecuada= false;
       if(nombre.equalsIgnoreCase("a")||nombre.equalsIgnoreCase("d")||nombre.equalsIgnoreCase("f")){
            letraAdecuada=true;
        }
       return letraAdecuada;
    }

    //MENSAJES
    public static void msjNoExiste(){
        System.out.println("Lo sentimos, el nombre ingresado no existe en nuestra base de datos");
    }
    public static void msjLetraErronea(){
        System.out.println("La letra introducida es erronea vuelvalo a intentar");
    }
    public static void msjArticuloCreado(){
        System.out.println("Articulo creado con éxito");
    }
    public static void msjArticuloEliminado (){
        System.out.println("Articulo eliminado");
    }

}
