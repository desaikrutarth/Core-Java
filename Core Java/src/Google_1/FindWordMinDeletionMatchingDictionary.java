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
 * Output: 9, 10, 11, 10 
 */

public class FindWordMinDeletionMatchingDictionary
{
	public static void removeChars(List<String> dictionary, String input)
	{
		for(String word : dictionary)
		{
			int wordIndex = 0;
			for(int i=0; i<input.length(); i++)
			{
				if(input.charAt(i) == word.charAt(wordIndex))
					wordIndex ++;
				
				if(wordIndex == word.length())
					break;
			}
			System.out.println(input.length()-wordIndex);
		}
	}
	
/*	static void removeChars(List<String> dictionaryList, String input)
	{
		List<Character> inputList = input.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		
		for(String word : dictionaryList)
		{
			List<Character> wordList = word.chars().mapToObj(c->(char)c).collect(Collectors.toList());
			List<Character> copyList = new ArrayList<>(inputList);
			copyList.removeAll(wordList);
			System.out.println(copyList.size());
		}
	}*/
	
	 public static void main(String args[]) 
	 {
		 List<String> dictionary = Arrays.asList("fellow", "hello", "whatsapp", "zukam");
		 String input = "zwhatufellkamow";
		 removeChars(dictionary, input);
	        
	 }

	    
}
