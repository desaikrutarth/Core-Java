package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 */
public class LongestWord 
{
	private static String longestWord(String[] words)
	{
		List<String> wordList = new ArrayList<String>(Arrays.asList(words));
		String result = "";
		
		for(String word : wordList)
		{
			if(word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0))
			{
				for(int i=1; i<word.length(); i++)
				{
					if(wordList.contains(word.substring(0,i)))
						result = word;
				}
			}
		}
		return result;
	}
	
	/*private static String longestWord(String[] words)
	{
		String ans = "";
        Set<String> wordset = new HashSet<>();
        for (String word: words)
        	wordset.add(word);
        
        for (String word: words)
        {
            if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0)
            {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k)
                {
                    if (!wordset.contains(word.substring(0, k)))
                    {
                        good = false;
                        break;
                    }
                }
                if (good)
                	ans = word;
            }    
        }
        return ans;
	}*/
	
	public static void main(String[] args) 
	{
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(longestWord(words));
	}
}
