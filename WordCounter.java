import java.io.FileReader;

public class WordCounter {

public static int[] count(String fileName) throws Exception{ 
		
		
	
		FileReader file = new FileReader("resources/" + fileName);
		int ch;
		int lcount = 0;
		int wcount = 0;
		int ccount = 0;
		while((ch = file.read()) != -1) {
			if((char)ch == '\n') {lcount++; wcount++;}
			if((char)ch == ' ') wcount++;
			ccount++;
		}
		file.close();
		int[] returnVals = {lcount, ccount, wcount};
		return returnVals;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 0) System.out.println("Brak argumentow programu.");
		else {
			String file = "";
			String flags = "";
			for(String a : args) {
				if(a.indexOf('-')!= -1) flags+=a;
				else file = a;
			}
			int[] results =new int[3];
			try {
				results = count(file);
			}
			catch(Exception e) {System.out.println("Wystapil blad");}
			System.out.println(flags);
			if(flags.indexOf('l') != -1) System.out.println("wierszy: " + results[0]);
			if(flags.indexOf('c') != -1) System.out.println("znakow: " + results[1]);
			if(flags.indexOf('w') != -1) System.out.println("slow: " + results[2]);
		}
		
		
		
	}
}
