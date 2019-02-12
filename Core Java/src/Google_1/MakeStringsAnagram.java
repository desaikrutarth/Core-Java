package Google_1;

import java.util.HashMap;

public class MakeStringsAnagram 
{
	static void MakeAnagrams(String s1, String s2)
	{
		HashMap<Character, Integer> hmap1 = new HashMap<>();
		HashMap<Character, Integer> hmap2 = new HashMap<>();
		for(int i=0; i<s1.length(); i++)
		{
			hmap1.merge(s1.charAt(i), 1, Integer::sum);
		}
		
		for(int i=0; i<s2.length(); i++)
		{
			hmap2.merge(s2.charAt(i), 1, Integer::sum);
		}
		
		int count = 0;
		for(char key : hmap1.keySet())
		{
			if(hmap2.containsKey(key))
			{
				int val1 = hmap1.get(key);
				int val2 = hmap2.get(key);
				
				while(val1 != val2) 
				{
					System.out.println(key);
					hmap1.put(key, val1--);
					count++;
				}
					
			}
			else
			{
				System.out.println(key);
				count++;
			}
		}
		System.out.println("No of characrers removed = "+count);
	}
	
	public static void main(String[] args)
	{
		String str1 = "ccdddgggk";
		String str2 = "gcd";
		MakeAnagrams(str1, str2);
	}
}
