import java.io.FileReader;
import javax.swing.JOptionPane;

public class LineCounterPane {


	public static int CountLines(String fileName) throws Exception{ //is this right use of throws
		
		FileReader file = new FileReader("resources/" + fileName);
		int ch;
		int count = 0;
		while((ch = file.read()) != -1) {
			if((char)ch == '\n') count++;
		}
		file.close();
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = JOptionPane.showInputDialog("list folders");
		String[] fileList = input.split(" ");
		if(input.length() == 0) System.out.println("Brak argumentow programu.");
		else {
			for(String fileName : fileList) {
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
