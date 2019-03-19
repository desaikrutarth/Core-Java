package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
 */
public class ShortestCompletingWord
{
	private static String shortestCompletingWord(String licensePlate, String[] words)
	{
		List<Character> licenceList = licensePlate.toLowerCase().chars().mapToObj(c->(char)c).filter(c -> Character.isLetter(c)).collect(Collectors.toList());
		int minWordlen = Integer.MAX_VALUE;
		String result = "";
		for(String word : words)
		{
			List<Character> differ = new ArrayList<>(licenceList);
			for(Character ch : word.toCharArray())
			{
				if(differ.contains(ch))
					differ.remove(ch);
			}
			
			if(differ.size() == 0 && minWordlen > word.length())
			{
				result = word;
				minWordlen = word.length();
			}
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		String licensePlate = "1s3 456";
		String[] words = {"looks", "pest", "stew", "show"};
		
		System.out.println(shortestCompletingWord(licensePlate, words));
	}

	
}
