package n1.Observer;

public class Main {

	public static void main(String[] args) {
		Subject subject = new Subject();
		subject.attach(new AgenciesBorsa("BBVA"));
		subject.attach(new AgenciesBorsa("NYC"));
		subject.attach(new AgenciesBorsa("LaCaixa"));
		
		subject.notifyAllObservers();;
		}

}
