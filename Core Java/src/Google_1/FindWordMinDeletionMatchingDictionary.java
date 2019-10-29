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
		List<Character> inputList = input.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		
		for(String word : dictionaryList)
		{
			List<Character> wordList = word.chars().mapToObj(c->(char)c).collect(Collectors.toList());
			List<Character> copyList = new ArrayList<>(inputList);
			copyList.removeAll(wordList);
			System.out.println(copyList.size());
		}
	}
	
	
	 public static void main(String args[]) 
	 {
		 List<String> dictionary = Arrays.asList("fellow", "hello", "whatsapp", "zukam");
		 String input = "zwhatufellkamow";
		 removeChars(dictionary, input);
	        
	 }

	    
}
