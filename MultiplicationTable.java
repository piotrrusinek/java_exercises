import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
 
public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties defaultProps = new Properties();
		FileInputStream in;
		Scanner sc = new Scanner(System.in);
		
		//create default file to be deleted after first use
		defaultProps.setProperty("wartosc_minimum", "1");
		defaultProps.setProperty("wartosc_maximum", "10");
		defaultProps.setProperty("procent", "70");		
		defaultProps.setProperty("powtorzen_minimum", "10");
		defaultProps.setProperty("powtorzen_maximum", "25");		
		try {
			FileOutputStream out = new FileOutputStream("resources/defaultProperties");
			defaultProps.store(out, "---No Comment---");
			out.close();
		}
		catch(Exception e) {}
		
		
		//try opening properites file 
		//if file doesnt exist create new one and get values from user
		try {
			in = new FileInputStream("resources/defaultProperties");
			defaultProps.load(in);
			in.close();
			System.out.println("pobrano wlasciwosci");
		}
		catch(FileNotFoundException fnfe) {
			try {
				
				System.out.print("set wartosc_minimum: ");
				defaultProps.setProperty("wartosc_minimum", sc.next());
				
				System.out.print("\nset wartosc_maximum: ");
				defaultProps.setProperty("wartosc_maximum", sc.next());
				
				System.out.print("\nset procent: ");
				defaultProps.setProperty("procent", sc.next());
				
				System.out.print("\nset powtorzen_minimum: ");
				defaultProps.setProperty("powtorzen_minimum", sc.next());
				
				System.out.print("\nset powtorzen_maximum: ");
				defaultProps.setProperty("powtorzen_maximum", sc.next());
				
				System.out.println("\n");
				
				FileOutputStream out = new FileOutputStream("resources/appProperties");
				defaultProps.store(out, "---No Comment---");
				out.close();
			}
			catch(Exception e) {
				System.out.println("problem with creating new properties file");
			}
		}
		catch(IOException ioe) {
			System.out.println("problem with accesing the properties files.");
		}
		String testval = defaultProps.getProperty("wartosc_maximum");
		int testvalint = Integer.valueOf(testval);
		System.out.println("property wartosc maximum: " + testvalint);
		int valMax = Integer.valueOf(defaultProps.getProperty("wartosc_maximum"));
		int valMin = Integer.valueOf(defaultProps.getProperty("wartosc_minimum"));
		int repMin = Integer.valueOf(defaultProps.getProperty("powtorzen_minimum"));
		int repMax = Integer.valueOf(defaultProps.getProperty("powtorzen_maximum"));
		
		Random generator = new Random();		
		int goodAnswers = 0;
		System.out.println("Zaczynamy test! \n");

		for(int i=0; (i<repMin); i++) {
			int first = generator.nextInt(valMax-valMin+1)+valMin;
			int second = generator.nextInt(valMax-valMin+1)+valMin;
			System.out.print(first+"*"+second+"= ");
			if(Integer.valueOf(sc.next()).equals(first*second)) goodAnswers++;
			System.out.println("\n");
		}
		float percentage = ((float)goodAnswers/(float)repMin);
		System.out.println("\nprocent = " + percentage);
		
		if((float)(percentage)<0.7) {
			System.out.println("\ntest nie zaliczony, kontynuujemy zadania :(\n");
			int i =0;
			for(i=0; i<(repMax-repMin) && ((float)goodAnswers/(float)(repMin+i))<0.7; i++) {
				int first = generator.nextInt(valMax-valMin+1)+valMin;
				int second = generator.nextInt(valMax-valMin+1)+valMin;
				System.out.print(first+"*"+second+"= ");
				if(Integer.valueOf(sc.next()).equals(first*second)) goodAnswers++;
				System.out.println("\n");
			}
			percentage = ((float)goodAnswers/(float)(repMin+i));
		}
		
		
		if(percentage>=0.7)System.out.println("\n\ntest zaliczony!"); 
		else {
			System.out.println("\n\ntest niezaliczony! :("); 
		}
		System.out.println("procent porprawnych odpowiedzi: " + (percentage*100) + "%");
		
		

	}

}
