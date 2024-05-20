import java.util.Date;

public class Weekend2 {

	public static void main(String[] args) {
		Date now = new Date();
		switch (now.getDay()){
		
		case 1:
			System.out.println("Dzis poniedzialek, do weekendu pozostaly " + (5-now.getDay()) + " dni.");
			break;
		case 2:
			System.out.println("Dzis wtorek, do weekendu pozostaly " + (5-now.getDay()) + " dni.");
			break;
		case 3:
			System.out.println("Dzis sroda, do weekendu pozostaly "+ (5-now.getDay()) + " dni.");
			break;
		case 4:
			System.out.println("Dzis czwartek, do weekendu pozostal "+ (5-now.getDay()) + " dzien.");
			break;
		case 5:
			System.out.println("Dzis piatek, do weekendu pozostalo "+ (5-now.getDay()) + " dni.");
			break;
		default:
			System.out.println("Mamy weekend!");
		}
		
		

	}

}
