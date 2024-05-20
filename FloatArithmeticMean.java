
public class FloatArithmeticMean {

	public static void main(String[] args) {
		
		if(args.length>1)
		{
			float sum = 0.0f;
			
			
			System.out.print("srednia arytmetyczna liczb " );
			for(String fl : args)
			{
				sum+=Float.parseFloat(String.format("%.3f", Float.parseFloat(fl)));
				System.out.printf(String.format("%.3f ", Float.parseFloat(fl)));
			}
			
			System.out.println("wynosi " + String.format("%.4f%n", (sum/(float)(args.length))));
			
			
		}
		else if(args.length==1) System.out.println("tylko jedna podana wartosc");
		else System.out.println("brak wartosci");

	}

}
