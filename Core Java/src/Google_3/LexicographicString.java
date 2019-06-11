package Google_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Find the Lexicographic next word of the input word from a list of words 
Example 
Words list 
[Cat, dog, cow, donkey, zebra, monkey], 
input 
duck 
output 
monkey 

Input 
dog 
output 
donkey 
Can you use trie to solve it? 
public String findNextWord(List<String> words, String input){ 
}
 */



public class LexicographicString
{
	static String findNextWord(List<String> wordsList, String input)
	{ 
		Collections.sort(wordsList);
		
		for(int i=0; i<wordsList.size(); i++)
		{
			String word = wordsList.get(i);
			
			if(word.equals(input) && i < wordsList.size()-1)
				return wordsList.get(i+1);
			else if(word.equals(input) && i == wordsList.size()-1)		//if last word match in dictionary
				return wordsList.get(i);
			else
			{
				if(input.compareTo(word) < 0)					//if word is not in dictionary
					return word;
			}
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		List<String> words = new ArrayList<>(Arrays.asList("cat", "dog", "cow", "donkey", "zebra", "monkey"));
		String input = "zebra";
		System.out.println(findNextWord(words, input));
	}
}
