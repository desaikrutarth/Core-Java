package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
/*
Given a string which only contains lowercase. You need delete the repeated letters only leave one, and try to make the lexicographical order of new string is smallest. 
i.e: 
bcabc 
You need delete 1 'b' and 1 'c', so you delete the first 'b' and first 'c', the new string will be abc which is smallest. 

ps: If you try to use greedy algorithm to solve this problem, you must sure that you could pass this case: 
cbacdcbc. answer is acdb not adcb 
 */
public class RemoveDuplicateCharacter
{
	static void removeDuplicates(String str)
	{
		Set<Character> set = str.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
		str = "";
		for(char ch : set)
			 str += ch;
		System.out.println(str);
	}
	
	/* Method 2: Without Set
	static void removeDuplicates(String str)
	{
		char[] chArray = str.toCharArray();
		Arrays.sort(chArray);
		
		String newstring = "";
		for(int i=1; i<chArray.length; i++)
		{
			if(chArray[i] != chArray[i-1])
			{
				newstring += chArray[i-1];
			}
			
			if(i == chArray.length-1)
			{
				newstring += chArray[i];
			}
		}
		System.out.println(newstring);
	}
	*/
	
	
	public static void main(String[] args)
	{
		removeDuplicates("cbacdcbc");
	}
}
