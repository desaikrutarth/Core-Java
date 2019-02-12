package General;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import practice.Practice;
/*
You have two arrays of strings, words and parts. Return an array that contains the strings from words,
modified so that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines: 
If several parts substrings occur in one string in words, choose the longest one.
If there is still more than one such part, then choose the one that appears first in the string. 
Example 
For words = ["Apple", "Melon", "Orange", "Watermelon"] and parts = ["a", "mel", "lon", "el", "An"], 
the output should be 
findSubstrings(words, parts) = ["Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"]. 

While "Watermelon" contains three substrings from the parts array, "a", "mel", and "lon", "mel" is the longest substring that appears first in the string.
 */

public class FindPartsFromWords 
{
	public String[] findPartsInWords(String[] words, String[] parts)
	{
		List<String> resultList = Arrays.stream(words)
										.map(word -> findParts(word, parts))
										.collect(Collectors.toList());

		String[] result = resultList.toArray(new String[resultList.size()]);
		return result;
	}

	private String findParts(String word, String[] parts)
	{
		String bestPart = Arrays.stream(parts)
								.filter(part -> word.contains(part))
								.sorted(Comparator.comparingInt(String::length).reversed())
								.findFirst()
								.orElse(word);

		if (!bestPart.equals(word))
			bestPart = replaceWord(word, bestPart);

		return bestPart;
	}

	private String replaceWord(String word, String part)
	{
		String wordReplaced = word;
		String replace = "[" + part + "]";
		wordReplaced = wordReplaced.replace(part, replace);
		return wordReplaced;
	}
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
		String[] parts = {"a", "mel", "lon", "el", "An"};
		
		FindPartsFromWords wordsAndParts = new FindPartsFromWords();
		String[] result = wordsAndParts.findPartsInWords(words, parts);
		
		Arrays.stream(result).forEach(System.out::println);
	}
}
