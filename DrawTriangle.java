import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DrawTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		
		
		try {
			n = sc.nextInt();
		}
		catch(InputMismatchException ime) {
			System.out.println("Input is not an intiger.");
		}
		catch(NoSuchElementException nse) {
			System.out.println("Input is exhausted.");
		}
		catch(IllegalStateException ise) {
			System.out.println("Scanner is closed.");
		}
		if(n<=2) System.out.println("Given value is incorrect.");
		else {
			
			//1+(n-1)*2    n*4-1
			int width = n*2-1;
			
			
			int i;
			int j;
			//saving memory instead of computation cost
			for(i = 1; i<=width; i+=2) {
				for(j=0;j<(width-i)/2;j++) System.out.print(" ");
				for(j=0;j<i;j++) System.out.print("#");
				for(j=0;j<(width-i)/2;j++) System.out.print(" ");
				System.out.print("\n");
			}
		}
		sc.close();

	}

}
