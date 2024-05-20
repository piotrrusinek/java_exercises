import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DrawSquare {

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
		if(n<=0) System.out.println("Given value is incorrect.");
		else {
			int i;
			for(i = 0; i<n; i++) System.out.printf("#");
			System.out.printf("\n");
			
			for(i=0;i<(n-2);i++) {
				System.out.printf("#");
				for(int j=0; j<(n-2); j++) System.out.printf(" ");
				System.out.printf("#\n");
			}
			for(i = 0; i<n; i++) System.out.printf("#");
		}
		
	}

}
