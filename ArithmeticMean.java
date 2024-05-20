import java.util.List;
import java.util.ArrayList;

public class ArithmeticMean {

	public static void main(String[] args) {
		
		
		if(args.length>1)
		{
			List<Integer> nums = new ArrayList<>();
			Integer sum = 0;
			for(String s : args)
			{
				nums.add(Integer.parseInt(s));
				sum+=Integer.parseInt(s);
			}
			System.out.println("srednia arytmetyczna liczb " + nums + " wynosi " + (sum/args.length));
		}
		else if(args.length == 1) System.out.println("Podano tylko jedna wartosc");
		else System.out.println("brak wartosci");

	}

}
