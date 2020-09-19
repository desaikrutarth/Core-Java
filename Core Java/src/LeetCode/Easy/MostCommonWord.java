package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not case sensitive. The answer is in lowercase.

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]

Output: "ball"

Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord 
{
	public static String mostCommonWord(String paragraph, String[] banned) 
	{
		ArrayList<String> bannedList = new ArrayList<>(Arrays.asList(banned));
		HashMap<String, Integer> hmap = new HashMap<>();
		
		for(String str : paragraph.split("\\W+"))	// '\\W+' matches any non-word character including white space.
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
	
	//Method 2: comparator iterator
/*	public static String mostCommonWord(String paragraph, String[] banned) 
	{
	    Map<String, Integer> map = new HashMap<>();
	    
	    for(String word : paragraph.split("\\W+"))
	    {
	        map.merge(word.toLowerCase(), 1, Integer:: sum);
	    }
	    
	    List<String> keyList = new ArrayList<>(map.keySet());
	    
	    //Sort keys by value desc
	    Collections.sort(keyList, (a,b) -> {
	        int fa = map.get(a);
	        int fb = map.get(b);
	        
	        if(fa > fb)
	          return -1;
	        if(fa < fb)
	          return 1;
	        return 0;
	    });
	    System.out.println(keyList);
	    List<String> bannedList = new ArrayList<>(Arrays.asList(banned));
	    for(String val : keyList)
	    {
	        if(!bannedList.contains(val))
	          return val;
	    }
	    return null;
	}
*/	
	
	public static void main(String[] args) 
	{
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		System.out.println(mostCommonWord(paragraph, banned));
	}
}
