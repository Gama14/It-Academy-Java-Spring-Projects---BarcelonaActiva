package n2.Callback;

public class CuentaBancaria implements CallbackPago {

	@Override
	public void pago() {
		System.out.println("Se ha retirado el dinero de la cuenta con éxito");
		
	}

}
