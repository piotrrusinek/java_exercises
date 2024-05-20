import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * file1 10
 * file2 4
 * file3 does not exist
 * file4 0
 * 
 */

//wrapping an InputStreamReader within a BufferedReader ??

public class LineCounter {
	
	public static int CountLines(String fileName) throws Exception{ //is this right use of throws
		
		FileReader file = new FileReader("resources/" + fileName);
		int ch;
		int count = 0;
		while((ch = file.read()) != -1) {
			if((char)ch == '\n') count++;
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length == 0) System.out.println("Brak argumentow programu.");
		else {
			for(String fileName : args) {
				try {
					int ln = LineCounter.CountLines(fileName);
					System.out.println(fileName + ": " + ln);
				}
				catch(Exception s) {
					System.out.println(fileName + ": No such file ");
				}
			}
		}

	}

}
