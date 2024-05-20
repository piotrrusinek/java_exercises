import java.util.Date;

public class Weekend {

	public static void main(String[] args) {
		Date now = new Date();
		int weekDay = now.getDay();
		System.out.println("Liczba dni do weekendu: " + (5-weekDay));

	}

}
