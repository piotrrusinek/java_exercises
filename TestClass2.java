import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TestClass2 {

	private static int count;
	private int id;
	private LocalDateTime creationTime;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
	public TestClass2() {
		count++;
		id = count;
		creationTime = LocalDateTime.now();
	}
	
	public String toString() {
		 return ("object id: " + id + " creation time: " + creationTime.format(formatter));
	}
	
	public static int getCount() {
		return count;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
		System.out.println("Witaj teraz jest: " + date);
		
		if(args.length>0) {
			for(int i = 1; i <= Integer.parseInt(args[0]); i++) {
				TestClass2 obj = new TestClass2();
				System.out.println(i + ". " + obj);
			}
			System.out.println("Liczba obiektow: " + TestClass2.getCount());
		}
		else System.out.println("Brak argumentow programu.");

	}

}
