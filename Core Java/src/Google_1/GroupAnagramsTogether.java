package Google_1;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Given an array of words, print the count of all anagrams together in sorted order (increasing order of counts).
   For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”},
   then grouped anagrams are “(dog, god) (cat, tac, act)”.

 */
public class GroupAnagramsTogether
{
	static void removeChars(List<String> dictionaryList)
	{
		HashMap<Set<Character>, Set<String>> hmap = new HashMap<>();
		for(String str : dictionaryList)
		{
			Set<Character> charSet = str.chars().mapToObj(c ->(char)c).collect(Collectors.toSet());
			if(hmap.containsKey(charSet))
			{
				Set<String> stringSet = hmap.get(charSet);
				stringSet.add(str);
			}
			else
			{
				Set<String> stringSet = new HashSet<>();
				stringSet.add(str);
				hmap.put(charSet, stringSet);
			}
		}
		
		for(Set<Character> key : hmap.keySet())
		{
			Set<String> valSet = hmap.get(key);
			System.out.println(valSet);
		}
	}
	
	public static void main(String args[]) 
	{
		 List<String> dictionary = Arrays.asList("cat", "dog", "tac", "god", "act");
		 removeChars(dictionary);
	}
}
