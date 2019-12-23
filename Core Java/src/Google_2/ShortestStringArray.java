package Google_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
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
/*	static List<String> findString(String[] words, String[] keywords)
	{
		ArrayList<String> wordList = new ArrayList<>();
		ArrayList<String> resultList = new ArrayList<>();
		
		boolean doesContain = false;
		String firstKeyword = keywords[0];
		String lastKeyword = keywords[1];
		int minnum = Integer.MAX_VALUE;
		
		for(String word : words)
		{
			if(word.equals(firstKeyword))
			{
				doesContain = true;
				wordList.clear();
			}
			
			if(doesContain)
				wordList.add(word);
			
			if(word.equals(lastKeyword))
			{
				doesContain = false;
				if(wordList.size() < minnum)
				{
					minnum = wordList.size();
					resultList = new ArrayList<>(wordList);
				}
				wordList.clear();
			}
		}
		return resultList;
	}
*/	
	
	static List<String> findString(String[] words, String[] keywords)
	{
		HashMap<String, List<Integer>> map = new HashMap<>();
		List<String> resultList = new ArrayList<>();
		
		int index=0;
		for(String word : words)
		{
			List<Integer> list = new ArrayList<>();
			
			if(map.containsKey(word))
				list = map.get(word);
			list.add(index++);
			map.put(word, list);
		}
		String first = keywords[0];
		String last = keywords[1];
		int firstIndex=0;
		int lastIndex=0;
		
		if(map.containsKey(first) && map.containsKey(last))
		{
			List<Integer> valList1 = map.get(first);
			firstIndex = valList1.get(valList1.size()-1);
			
			List<Integer> valList2 = map.get(last);
			lastIndex = valList2.get(0);
			
			if(firstIndex > lastIndex)
			{
				firstIndex = valList1.get(0);
				lastIndex = valList2.get(0);
			}
			
			for(int i=firstIndex; i<=lastIndex; i++)
				resultList.add(words[i]);
		}
		
		return resultList;
	}
	
	public static void main(String[] args)
	{
		//String[] words = {"abc","sky","cloud","blue","xyz","sky","search","work","blue"};
		String[] words = {"sky", "cloud", "google", "search", "sky", "work","sky","blue","abc","blue"};
		String[] keywords = {"sky","blue"};
		
		System.out.println(findString(words, keywords));
	}
}
