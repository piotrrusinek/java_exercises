
public class CommandLineArguments {

	public static void main(String[] args) {
		
		if(args.length>0)
		{
			System.out.println("Liczba argumentow: " + args.length);
			for(int x=0; x<args.length; x++)
			{
				System.out.println(x+1 + ". " + args[x]);
			}
			
		}
		else System.out.println("Brak argumentow programu.");

	}

}
