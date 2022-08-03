package n3.DependencyInjection;

public class Main {

	public static void main(String[] args) {
		LlistaCompra llista= new LlistaCompra ();
		Articles a1= new Articles (8.32,"Camiseta" );
		Articles a2= new Articles (2.99,"Refresco" );
		Articles a3= new Articles (120,"PlayStation3" );
		
		llista.AddLlista(a1);
		llista.AddLlista(a2);
		llista.AddLlista(a3);
		
		llista.mostrarArticles();
		llista.cambioMoneda(new Dolar());
		llista.cambioMoneda(new LibraEsterlina());
		llista.cambioMoneda(new Yen());
	}

}
