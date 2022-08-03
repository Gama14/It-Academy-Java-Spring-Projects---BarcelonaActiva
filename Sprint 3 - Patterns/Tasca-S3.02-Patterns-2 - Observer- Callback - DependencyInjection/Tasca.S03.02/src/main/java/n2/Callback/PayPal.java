package n2.Callback;

public class PayPal implements CallbackPago {

	@Override
	public void pago() {
		System.out.println("El pago con PayPal se ha realizado con éxito!");
		
	}

}
