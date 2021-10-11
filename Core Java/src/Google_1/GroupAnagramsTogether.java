package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
		Map<String, List<String>> map = new HashMap<>();
		
		for(String word : dictionaryList)
		{
			//Sorting a string java 8
			String sorted = word.chars()
				             .sorted()
				             .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				             .toString();
			
			map.computeIfAbsent(sorted, (list)-> new ArrayList<>());
	        map.get(sorted).add(word);
		}
		
		TreeMap<Integer, List<String>> tmap = new TreeMap<>();
		
		for(List<String> valSet : map.values())
		{
			tmap.put(valSet.size(), valSet);
		}
		
		System.out.println(tmap.values());
	}
	
/*	static void removeChars(List<String> dictionaryList)
	{
		HashMap<Set<Character>, Set<String>> map = new HashMap<Set<Character>, Set<String>>();
		
		for(String word : dictionaryList)
		{
			Set<Character> charSet = word.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
			map.computeIfAbsent(charSet, (set) -> new HashSet<>());
			map.get(charSet).add(word);
		}
		
		TreeMap<Integer, Set<String>> tmap = new TreeMap<Integer, Set<String>>();
		
		for(Set<String> wordSet : map.values())
		{
			tmap.put(wordSet.size(), wordSet);
		}
		
		System.out.println(tmap.values());
	}
*/
	
//	static void removeChars(List<String> dictionaryList)
//	{
//		HashMap<Set<Character>, Set<String>> map = new HashMap<Set<Character>, Set<String>>();
//		
//		for(String word : dictionaryList)
//		{
//			Set<Character> charSet = word.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
//			Set<String> wordSet = new HashSet<String>();
//			if(map.containsKey(charSet))
//			{
//				wordSet = map.get(charSet);
//			}
//			wordSet.add(word);
//			map.put(charSet, wordSet);
//		}
//		
//		TreeMap<Integer, Set<String>> tmap = new TreeMap<Integer, Set<String>>();
//		
//		for(Set<String> wordSet : map.values())
//		{
//			tmap.put(wordSet.size(), wordSet);
//		}
//		
//		System.out.println(tmap.values());
//	}

	
	public static void main(String args[]) 
	{
		 List<String> dictionary = Arrays.asList("cat", "dog", "tac", "god", "act");
		 removeChars(dictionary);
	}
}
