package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

Keyboard: Q W E R T Y U I O P 
			A S D F G H J K L 
			 Z X C V B N M
 
Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 */
public class KeyboardRow
{
	private static void findWords(String[] words)
	{
		String[] keyboard = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		List<String> outputList = new ArrayList<>();
		for(String row : keyboard)
		{
			List<Character> rowList = row.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.toList());
			for(String word : words)
			{
				List<Character> wordList = word.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.toList());
				
				if(rowList.containsAll(wordList))
					outputList.add(word);
			}
		}
		System.out.println(outputList);
	}
	
	public static void main(String[] args) 
	{
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		findWords(words);
	}

	
}
