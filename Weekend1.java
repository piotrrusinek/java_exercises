import java.util.Date;

public class Weekend1 {

	public static void main(String[] args) {
		Date now = new Date();
		switch (now.getDay()){
		
		case 1:
			System.out.println("Dzis jest poniedzialek.");
			break;
		case 2:
			System.out.println("Dzis jest wtorek.");
			break;
		case 3:
			System.out.println("Dzis jest sroda.");
			break;
		case 4:
			System.out.println("Dzis jest czwartek.");
			break;
		case 5:
			System.out.println("Dzis jest piatek.");
			break;
		default:
			System.out.println("Jest weekend.");
		}

	}

}
