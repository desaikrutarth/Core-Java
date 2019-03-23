package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

public class MostCommonWord 
{
	public static String mostCommonWord(String paragraph, String[] banned) 
	{
		ArrayList<String> bannedList = new ArrayList<>(Arrays.asList(banned));
		HashMap<String, Integer> hmap = new HashMap<>();
		
		for(String str : paragraph.split("\\W"))	// '\\W' matches any non-word character.
			hmap.merge(str.toLowerCase(), 1, Integer::sum);
		
		hmap = hmap.entrySet()			// sort Hashmap by value in desc order
		        	.stream()
		        	.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))		        	
		        	.collect(
		        			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)
		        			);
		System.out.println(hmap);
		
		
		for(Entry<String, Integer> entry : hmap.entrySet())
		{
			if(!bannedList.contains(entry.getKey()))
				return entry.getKey();
		}
		
		return null;
	}

	public static void main(String[] args) 
	{
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		System.out.println(mostCommonWord(paragraph, banned));
	}
}
