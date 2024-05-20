

public class TestClass {

	private static int count;
	private int id;
	private long creationTime;
	public TestClass() {
		count++;
		id = count;
		creationTime = System.currentTimeMillis();
	}
	
	public String toString() {
		 return ("object id: " + id + " object created: " + creationTime + "ms");
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		
		
		if(args.length>0) {
			for(int i = 1; i <= Integer.parseInt(args[0]); i++) {
				TestClass obj = new TestClass();
				System.out.println(i + ". " + obj);
			}
			System.out.println("Liczba obiektow: " + TestClass.getCount());
		}
		else System.out.println("Brak argumentow programu.");

	}

}
