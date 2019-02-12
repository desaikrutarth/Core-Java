package programs;
/*Remove Alternate Duplicate characters from a char array you have to do it in Place.Like keeping only the odd occurences of each character.
Example:

Input: “you got beautiful eyes”

Output: ”you gtbeaiful es”
*/

import java.util.*;

public class RemoveDuplicates 		//Method 1
{
	char[] removeAlternateDuplicates(char str[])
	{
		int[] letters = new int[256];
		int i = 0;
		int index=0;

		for(i=0; i<str.length;i++)
		{
			char lowerCase = str[i];

			if(letters[lowerCase] == 0)
			{
				letters[lowerCase]++;
				str[index++]=str[i];
			}
			else
			{
				letters[lowerCase]--; // We want to Alternate
			}
		}
		while(index < i)
		{
			str[index++]= 0;
		}
		return str;
	}
	
	void removeDuplicates()		//Method 2
	{
		String inputString = "you got beautiful eyes";
		String outputString = "";
		HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Please Enter String:");
		//inputString = sc.nextLine();
		for (int i = 0; i < inputString.length(); i++) {
			if (!dictionary.containsKey(inputString.toLowerCase().charAt(i))) {
				dictionary.put(inputString.toLowerCase().charAt(i), 1);
				outputString += inputString.charAt(i);
			}
		}
		System.out.println(outputString);
	}
	
	public static void main(String[] args)
	{
		RemoveDuplicates obj = new RemoveDuplicates();
		String str = "you got beautiful eyes";
		char[] charArray = str.toCharArray();
		//obj.removeDuplicates();
		charArray = obj.removeAlternateDuplicates(charArray);
		for(int i = 0; i < charArray.length; i++)
		{
			System.out.print(charArray[i]);
		}
	}
}
