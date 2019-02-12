package Google_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Giving a dictionary and a string ‘str’, your task is to find the longest string in dictionary of size x,
 *  which can be formed by deleting some characters of the given ‘str’.
 *  Examples:

	Input : dict = {"ale", "apple", "monkey", "plea"}   
        	str = "abpcplea"  
	Output : apple

	Input  : dict = {"pintu", "geeksfor", "geeksgeeks", " forgeek"}                                         
         	 str = "geeksforgeeks"
	Output : geeksgeeks
 */

public class LargestWordDictionary 
{
	static String findWord(String[] arr, String str)
	{
		List<Character> charList = str.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		String result = "";
		for(String items : arr)
		{
			List<Character> list = items.chars().mapToObj(c->(char)c).collect(Collectors.toList());
			if(charList.containsAll(list))
			{
				if(items.length() > result.length())
					result = items;
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		String[] arr = {"ale", "apple", "monkey", "plea"};
		String str = "abpcplea";
		
		System.out.println(findWord(arr, str));
	}
}
