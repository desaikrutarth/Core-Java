package Google_1;

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
		Map<Set<Character>, Set<String>> map = new HashMap<>();
		
		for(String word : dictionaryList)
		{
			Set<Character> charSet = word.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
			Set<String> wordSet = new HashSet<String>();
			
			if(map.containsKey(charSet))
				wordSet = map.get(charSet);
			wordSet.add(word);
			map.put(charSet, wordSet);
		}
		
		TreeMap<Integer, Set<String>> tmap = new TreeMap<>();
		
		for(Set<String> valSet : map.values())
		{
			tmap.put(valSet.size(), valSet);
		}
		
		for(Set<String> valSet : tmap.values())
		{
			System.out.println(valSet);
		}
		
	}
//	static void removeChars(List<String> dictionaryList)
//	{
//		HashMap<Set<Character>, Set<String>> hmap = new HashMap<>();
//		for(String str : dictionaryList)
//		{
//			Set<Character> charSet = str.chars().mapToObj(c ->(char)c).collect(Collectors.toSet());
//			if(hmap.containsKey(charSet))
//			{
//				Set<String> stringSet = hmap.get(charSet);
//				stringSet.add(str);
//			}
//			else
//			{
//				Set<String> stringSet = new HashSet<>();
//				stringSet.add(str);
//				hmap.put(charSet, stringSet);
//			}
//		}
//		
//		TreeMap<Integer,Set<String>> treeMap = new TreeMap<>();
//
//		//Sort Set of Values by it's size by TreeMap.
//		for(Set<String> valSet : hmap.values())
//		{
//			treeMap.put(valSet.size(),valSet);
//		}
//			
//		for(Set<String> valSet : treeMap.values())
//		{
//			System.out.println(valSet);
//		}
//
//	}
	
	public static void main(String args[]) 
	{
		 List<String> dictionary = Arrays.asList("cat", "dog", "tac", "god", "act");
		 removeChars(dictionary);
	}
}
