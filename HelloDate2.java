import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HelloDate2 {

	public static void main(String[] args) {
		DateFormat form = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		Date now = new Date();
		String nowFormated = form.format(now);
		System.out.println("Witaj! Teraz jest: " + nowFormated);

	}

}
