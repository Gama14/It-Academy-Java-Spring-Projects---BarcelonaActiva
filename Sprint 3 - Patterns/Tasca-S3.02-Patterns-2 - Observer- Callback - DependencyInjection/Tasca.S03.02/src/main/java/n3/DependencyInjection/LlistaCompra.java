package n3.DependencyInjection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LlistaCompra {
	List <Articles> LlistaArticles=new ArrayList <Articles>();
	
	public void AddLlista(Articles article) {
		LlistaArticles.add(article);
		
	}
	public void cambioMoneda(ConversorMoneda conversor) {
		HashMap<String, Double> articles_act = new HashMap<>();
		
		for(int i=0; i< LlistaArticles.size();i++) {
			
			double valor = Math.round( conversor.conversion(LlistaArticles.get(i))* 100d) / 100d;
			articles_act.put(LlistaArticles.get(i).getName(), valor);
		}
		System.out.println(articles_act);
	}	
	public void mostrarArticles() {
		LlistaArticles.forEach(x->System.out.println(x.getName()+":"+x.getPreu()+" "+x.getMoneda()));
	}
	
}
