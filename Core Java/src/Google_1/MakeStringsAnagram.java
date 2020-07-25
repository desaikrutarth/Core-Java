package Google_1;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MakeStringsAnagram 
{
	public static void MakeAnagrams(String s1, String s2)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char ch : s1.toCharArray())
			map.merge(ch, 1, Integer::sum);
		
		for(char ch : s2.toCharArray())
		{
			if(map.containsKey(ch))
			{
				if(map.get(ch) == 0)
					map.remove(ch);
				else
					map.put(ch, map.get(ch)-1);
			}	
		}
		
		int total=0;
		for(char ch : map.keySet())
		{
			total += map.get(ch);
			System.out.println(map.get(ch)+" character "+ch+" removed");
		}
		System.out.println("No of characrers removed = "+total);
	}
	
	/*static void MakeAnagrams(String s1, String s2)
	{
		int[] arr = new int[26];
		
		for (char c : s1.toCharArray())
			arr[c - 'a']++;
		
		for (char c : s2.toCharArray())
		{
			if (--arr[c - 'a'] < 0)
				return -1;
		}
		
		int cnt = 0;
		for (int i : arr)
		{
			if (i > 0)
				cnt+=i;
		}
		return cnt;
	}*/
	
	public static void main(String[] args)
	{
		String str1 = "ccdddgggk";
		String str2 = "gcd";
		MakeAnagrams(str1, str2);
	}
}
