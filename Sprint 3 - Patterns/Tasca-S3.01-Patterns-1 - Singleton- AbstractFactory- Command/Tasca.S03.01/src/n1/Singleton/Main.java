package n1.Singleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Undo u = Undo.getComando();
		u.addComando("hola");
		u.addComando("casa");
		u.addComando("adios");
		u.eliminarUltimoComando();
		u.history();
	}

}
