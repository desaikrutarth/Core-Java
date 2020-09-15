package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.stream.Collectors;

/*Given a string and dictionary of words, form a word by removing minimum number of characters. Characters can be removed in-order only.
 * Example:	
 * 	dictionary:{"fellow", "hello", "whatsapp", "zukam"}
 * 	inputstring = "zwhatufellkamow";
 * Output: 9, 10, 10, 10 
 */

public class FindWordMinDeletionMatchingDictionary
{
	public static void removeChars(List<String> dictionary, String input)
	{
	    for(String word : dictionary)
	    {
	        int count = getCount(word, input);
	        System.out.println(count);
	    }
	}

	private static int getCount(String word, String input)
	{
	    int index = 0;
	    int length = input.length()-1;
	    
	    for(int i=0; i<input.length(); i++)
	    {
	        if(index < word.length() && word.charAt(index) == input.charAt(i)) 
	        {
	            index++;
	            length--;
	        }
	        if(index == word.length()-1)
	          break;
	    }
	    return length;
	}
	
/*	public static void removeChars(List<String> dictionary, String input)
	{
		for(String word : dictionary)
		{
			List<Character> wordCharList = word.chars().mapToObj(c->(char)c).collect(Collectors.toList());
			List<Character> charList = input.chars().mapToObj(c->(char)c).collect(Collectors.toList());
			
			for(int i=0; i<word.length(); i++)
			{
				if(charList.contains(word.charAt(i)))
				{
					char ch = word.charAt(i);
					charList.remove(charList.indexOf(ch));
					wordCharList.remove(wordCharList.indexOf(ch));
				}
			}
			System.out.println(charList.size());
		}
	}
*/	
	 public static void main(String args[]) 
	 {
		 List<String> dictionary = Arrays.asList("fellow", "hello", "whatsapp", "zukam");
		 String input = "zwhatufellkamow";
		 removeChars(dictionary, input);
	        
	 }

	    
}
