package LeetCode.Easy;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/*
Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest. 
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    		 Note that "i" comes before "love" due to a lower alphabetical order.
    
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    		with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
public class TopKFrequentWords
{
	public static List<String> topKFrequent(String[] words, int k)
    {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words)
        {
            map.merge(word, 1, Integer::sum);
        }
        
        List<String> wordList = new ArrayList<>(map.keySet());
        
        Collections.sort(wordList, (a,b)->{
            int fa = map.get(a);
            int fb = map.get(b);
            
            if(fa < fb)
                return 1;
            if(fa > fb)
                return -1;
            
            return a.compareTo(b);
        });
        
//      map = map.entrySet()			
//    			 .stream()
//    			 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))		        	
//    			 .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        
        return wordList.subList(0, k);
    }
	
	public static void main(String[] args)
	{
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		
		System.out.println(topKFrequent(words, k));
	}
}
