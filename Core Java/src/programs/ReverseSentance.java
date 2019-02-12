package programs;

public class ReverseSentance {

	public static void main(String[] args) 
	{	
		String str = "My name is Krutarth";
		String[] splited = str.split("\\s+");
		for(int i = splited.length-1; i>=0; i--)
		{
			System.out.print(splited[i]+" ");
		}
		

	}

}
