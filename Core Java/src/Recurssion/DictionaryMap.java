package Recurssion;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
 * To a word, and a map, map which is a word, ask this if a word is smashable? 
 * That is, you can smash one letter each time, and the rest of the letters can form a single word (the new word is still in the map) until it is completely hit. 
For example: sprint -> print -> pint -> pit -> it -> i -> ""

 */
public class DictionaryMap
{
	public static Stack<String> wordStack = new Stack<>();
	static boolean smashable(String word, Set<String> dictionary) 
	{
		int wordLen = word.length();
		if (wordLen == 0) {
			return true;
		}

		for (int i = 0; i < wordLen; i++) 
		{
			String smashedWord = word.substring(0, i) + word.substring(i + 1);
			if (smashedWord.equals("") || dictionary.contains(smashedWord))
			{
				wordStack.push(word);
				if (smashable(smashedWord, dictionary))
					return true;
				//backtracking
				wordStack.pop();
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		String word = "sprint";
		Set<String> dictionary = new HashSet<>();
		dictionary.add("print");
		dictionary.add("pint");
		dictionary.add("pit");
		dictionary.add("it");
		dictionary.add("i");
		dictionary.add("");
		
		if(smashable(word, dictionary)) {
			System.out.println("Smashable!! "+wordStack.toString());
		}
		else {
			System.out.println("Not Smashable!!!");
		}
    }
}
