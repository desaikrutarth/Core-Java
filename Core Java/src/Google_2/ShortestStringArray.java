package Google_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
	static List<String> findString(String[] words, String[] keywords)
	{
		Stack<String> stack = new Stack<>();
		LinkedList<String> resultList = new LinkedList<String>(Arrays.asList(words));
		
		String start = keywords[0];
		String last = keywords[1];
		
		if(!resultList.contains(start) || !resultList.contains(last))
			return null;
		
		for(String word : words)
		{
			if(word.equals(last))
			{
				if(!stack.isEmpty() && stack.contains(start))
				{
					LinkedList<String> poplist = new LinkedList<String>();
					String pop;
					while(!(pop = stack.pop()).equals(start))
					{
						poplist.add(pop);
					}
					poplist.addFirst(pop);
					poplist.addLast(word);
						
					if(poplist.size() < resultList.size())
						resultList = poplist;
				}
			}
			else
				stack.push(word);
		}
		return resultList;
	}

	public static void main(String[] args)
	{
		//String[] words = {"abc","sky","cloud","blue","xyz","sky","search","work","blue"};
		String[] words = {"sky", "cloud", "google", "search", "sky", "blue","blue","abc","blue"};
		String[] keywords = {"sky","blue"};
		
		System.out.println(findString(words, keywords));
	}
}
