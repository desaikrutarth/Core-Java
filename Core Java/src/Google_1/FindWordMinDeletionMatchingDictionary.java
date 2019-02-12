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
 * Output: 8, 10, 9, 9 
 */

public class FindWordMinDeletionMatchingDictionary
{
	
	static void removeChars(List<String> dictionaryList, String input)
	{
		ArrayList<Character> charList = new ArrayList<>();
		for(int i=0; i<input.length(); i++)
			charList.add(input.charAt(i));
		
		for(String str : dictionaryList)
		{
			List<Character> list = str.chars()
									  .mapToObj(e->(char)e)
									  .collect(Collectors.toList());    // Convert String to Character List
			
			List<Character> difference = new ArrayList<>(charList);    //Copy charList to new List
			difference.removeAll(list);								   //Get the difference of two list
			System.out.println(difference.size());
		}
	}
	
	
	 public static void main(String args[]) 
	 {
		 List<String> dictionary = Arrays.asList("fellow", "hello", "whatsapp", "zukam");
		 String input = "zwhatufellkamow";
		 removeChars(dictionary, input);
	        
	 }

	    
}
