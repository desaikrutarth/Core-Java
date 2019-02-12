package programs;

public class LengthOfString 
{
	public static void main(String[] args)
	{
		String str = "Krutarth Desai";
		char[] ch = str.toCharArray();
		int length=0;
		
		for(Character cha : ch)
		{
			length++;
		}
		System.out.println("length= "+length);
	}
}
