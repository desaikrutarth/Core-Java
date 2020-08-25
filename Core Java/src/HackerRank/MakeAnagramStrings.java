package HackerRank;
/*
Given two strings, s1 and s2, that may or may not be of the same length,
determine the minimum number of character deletions required to make s1 and s2 anagrams.
Any characters can be deleted from either of the strings.

For example, if  and , we can delete  from string  and  from string  so that both remaining strings are  and  which are anagrams.
Sample Input:
cde
abc

Sample Output:
4

Explanation:

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.
 */
import java.util.*;

public class MakeAnagramStrings
{
	static int count = 0;
	static int makeAnagram(String s1, String s2)
    {
		getCounts(new HashMap<>(), s1, s2);
		getCounts(new HashMap<>(), s2, s1);
		
		return count;
    }
	
	private static void getCounts(Map<Character,Integer> map, String str1, String str2)
	{
		for(char ch : str1.toCharArray())
			map.merge(ch, 1, Integer::sum);
		
		for(char ch : str2.toCharArray())
		{
			if(map.containsKey(ch))
			{
				if(map.get(ch) > 0)
					map.put(ch, map.get(ch)-1);
				else
				{
					map.remove(ch);
					count++;
				}
			}
			else
				count++;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(makeAnagram("cde", "abc"));
//		System.out.println(makeAnagram("showman", "woman"));	//output: 2
//		System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));	//output: 30
	}

}
