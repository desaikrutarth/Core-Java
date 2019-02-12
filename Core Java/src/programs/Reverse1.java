package programs;

public class Reverse1 
{
	public static void main(String[] args) 
	{
		String str = "Hello";
		//char[] ch = str.toCharArray();
	
		String reverse = "";
		for(int i=str.length()-1; i>=0; i--)
		{
			reverse += str.charAt(i);			
		}
		System.out.print(reverse);
	}
}
