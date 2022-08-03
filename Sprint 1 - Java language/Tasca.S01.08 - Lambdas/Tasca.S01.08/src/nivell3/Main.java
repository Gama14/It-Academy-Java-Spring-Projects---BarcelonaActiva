package nivell3;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		
		List<Alumnos> lista = new ArrayList<Alumnos>();
		
		lista.add(new Alumnos("Pedo",38,"Java",4));
		lista.add(new Alumnos("Lucas",28,"Historia",4));
		lista.add(new Alumnos("Serafina",24,"Medicina",7));
		lista.add(new Alumnos("Anna",65,"Phyton",6));
		lista.add(new Alumnos("Paula",25,"Musica",(float) 7.4));
		lista.add(new Alumnos("Roque",35,"PHP",(float) 5.8));
		lista.add(new Alumnos("Juana",45,"Arquitectura",(float) 8.7));
		lista.add(new Alumnos("Lisandro",31,"Java",(float) 4.8));
		lista.add(new Alumnos("Alberta",27,"Economia",(float) 8.9));
		lista.add(new Alumnos("Juan",28,"Pintura",(float) 6.8));
		
		System.out.println("********************Ejercicio 1********************");
		
		//ejercicio 1
		//Muestra  por pantalla el  nombre  y  la edad  de cada  alumno . 
		lista.stream().flatMap(l -> Stream.of("nombre:" + l.getNombre() + ",edad:" + l.getEdad()))
					.collect(Collectors.toList())
					.forEach(System.out::println); 
		
		System.out.println();
		System.out.println("********************Ejercicio 2********************");
		
		//ejercicio 2
		//Filtrar la lista para  todos los estudiantes  que el  nombre comenzó  a "a",
		// asigna- que  a  otra  lista y  muestra  en pantalla la nueva lista ( todos con  lambdas)        
		List<Alumnos> listaA = lista.stream()
					.filter(l->l.getNombre().startsWith("A"))
					.collect(Collectors.toList());
		System.out.println("Alumnos que empiezan por A: " + listaA);
		
		System.out.println();
		System.out.println("********************Ejercicio 3********************");
		
		//ejercicio 3
		//Filtra y  muestra  por pantalla a  los alumnos  que  tengan  un 5 o más de nota.   
		lista.stream()
			.filter(l->l.getNota() >= 5)
			.forEach(System.out::println);
			
	//	System.out.println("Alumnos que tienen mas de 5: " + lista5oMas);
		
		System.out.println();
		System.out.println("********************Ejercicio 4********************");

		//ejercicio 4
		//Filtra y  muestra  por pantalla a  los alumnos  que  tengan  un 5 o más de nota y que no  sean  de PHP.   
		lista.stream()
				.filter(l->l.getNota() >= 5 && !l.getCurso().equalsIgnoreCase("PHP"))
				.forEach(System.out::println);
		
		System.out.println();
		System.out.println("********************Ejercicio 5********************");

		//ejercicio 5
		lista.stream()
		.filter(l->l.getEdad() >= 18 && l.getCurso().equalsIgnoreCase("JAVA"))
		.forEach(System.out::println);
		
	}
}