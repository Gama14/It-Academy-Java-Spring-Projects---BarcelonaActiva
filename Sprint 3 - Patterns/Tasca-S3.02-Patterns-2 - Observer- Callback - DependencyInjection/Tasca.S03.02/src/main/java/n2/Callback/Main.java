package n2.Callback;

public class Main {

	public static void main(String[] args) {
		CallbackPago Sara_GM = new TargetaCredito();
		CallbackPago Iris_GM = new PayPal();
		CallbackPago Feli_GC = new CuentaBancaria();
		
		TiendaZapatos adidas = new TiendaZapatos();

		adidas.registrarPagos(Sara_GM);
		adidas.registrarPagos(Iris_GM);
		adidas.registrarPagos(Feli_GC);

	}

}
