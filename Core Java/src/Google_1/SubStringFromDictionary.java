package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a dictionary and a string, find all the substrings that are valid words in dictionary. 
 * Example:
 *    Dictionary: ["abc", "kx", "acd", "bc", "abj", "ab", "bcd"]
 * 		  String: "abcd"
 * 
 * 		Output: abc, bc, ab, bcd
 * 		 
 */
public class SubStringFromDictionary
{
	static void getSubStringsFromDictionary(String input, List<String> dictionary)
	{
		List<String> list= new ArrayList<>();
		for(String item: dictionary)
		{
			if(input.contains(item))
			{
				list.add(item);
			}
		}
		
		for(String item: list)
			System.out.println(item);
		
	}
	
	public static void main(String[] args) 
	{
	    List<String> dictionary = Arrays.asList("abc", "kx", "acd", "bc", "abj", "ab", "bcd");
	    getSubStringsFromDictionary("abcd", dictionary);
	}
}
