package programs;
/*
 * Remove “b” and “ac” from a given string
 * Example:
	acbac -> ""
	aababc -> aaac

 */
public class RemoveCharacterFromString 
{
	static void removeCharacter(String str)
	{
		String newString = "";
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) =='b')
				continue;
			
			if(i<str.length()-1 && str.substring(i, i+2).equals("ac"))
			{
				i++;
				continue;
			}
						
			newString += str.charAt(i);	
				
		}
		System.out.println(newString);
	}
	
	public static void main(String[] args)
	{
		String str = "aababc";
		removeCharacter(str);
	}
}
