package n2.Callback;

public class TargetaCredito implements CallbackPago {

	@Override
	public void pago() {
		System.out.println("El pago con targeta de crédito se ha realizado con éxito! ");
		
	}

}
