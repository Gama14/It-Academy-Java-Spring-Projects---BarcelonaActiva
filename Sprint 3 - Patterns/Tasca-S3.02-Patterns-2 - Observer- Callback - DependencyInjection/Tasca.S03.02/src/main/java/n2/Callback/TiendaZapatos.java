package n2.Callback;

public class TiendaZapatos {
	private CallbackPago pago;
	
	public void registrarPagos (CallbackPago pago) {
		pago.pago();
	}
	

}
