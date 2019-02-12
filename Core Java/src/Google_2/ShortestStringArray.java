package Google_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 Give a string [] words, 
Find the shortest string [] containing the keyword inside. 
example: 
	words: sky cloud google search sky work blue 
	keywords: sky blue 
Output: sky work blue
 */
public class ShortestStringArray 
{
	static void findString(String[] words, String[] keywords)
	{
		 	Map<String, Integer> wordsMap = new LinkedHashMap<>();
	        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
	        ArrayList<String> list = new ArrayList<>();
	        
	        int startIndex =0;
	        int endIndex = 0;

	        for (int index = 0; index < words.length; index++)
	        {
	            if (keywordSet.contains(words[index]))
	            {
	                wordsMap.remove(words[index]);
	                wordsMap.put(words[index], index);
	                
	            }
	        }	       
	        
	        int count =0;
	        for(int val : wordsMap.values())
	        {
	        	if(count == 0)
	        		startIndex = val;
	        	else
	        		endIndex = val;
	        	count++;
	        }

	       for(int i = startIndex; i <= endIndex; i++) {
	    	   list.add(words[i]);
	       }
	       
	       System.out.println(list);

	}
	
/*	Method 2:
    static void findString(String[] words, String[] keywords)
	{
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		
		for(int i=0; i<words.length; i++)
		{
			if(map.containsKey(words[i]))
				map.remove(words[i]);
			map.put(words[i], i);
		}
		
		String first = keywords[0];
		String last = keywords[1];
		int startIndex = 0;
		int endIndex = 0;
		
		if(map.containsKey(first))
			startIndex = map.get(first);
		
		if(map.containsKey(last))
			endIndex = map.get(last);
		
		for(int i=startIndex; i <= endIndex; i++)
			System.out.println(words[i]);
	}*/
	
	public static void main(String[] args)
	{
		String[] words = {"sky","cloud","google","search","sky","work","blue"};
		String[] keywords = {"sky","blue"};
		
		findString(words, keywords);
	}
}
