package n3.Command;

public class Main {

	public static void main(String[] args) {
		Vehiculo v1= new Vehiculo("coche");
		Vehiculo v2 = new Vehiculo ("bicicleta");
		Vehiculo v3 = new Vehiculo ("avion");
		Vehiculo v4 = new Vehiculo ("barco");
		
	    Coche  c1= new Coche (v1);
		Bicicleta b1= new Bicicleta(v2);
		Avion a1 = new Avion(v3);
		Barco bar1= new Barco (v4); 

	      Broker broker = new Broker();
	      broker.takeOrder(c1);
	      broker.takeOrder(b1);
	      broker.takeOrder(a1);
	      broker.takeOrder(bar1);
	      

	      broker.placeOrders();
	   }

}
