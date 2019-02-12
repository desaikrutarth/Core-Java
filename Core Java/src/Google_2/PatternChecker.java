package Google_2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 Example: pattern = 'abcabc' 
				s = '123123' -> True 
				s = 'cbzabc' -> False 
				s = 'xyzxyz' -> True 
 */
public class PatternChecker
{
	static boolean isEncoded(String pattern, String str) 
	{
		String s1 = "";
		String s2 = "";
		LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();
		
		for(int i=0; i<pattern.length(); i++)
		{
			if(map1.containsKey(pattern.charAt(i)))
			{
				int val = map1.get(pattern.charAt(i));
				s1 += val;
				map1.remove(pattern.charAt(i));
			}
			else
			{
				s1 += i;
				map1.put(pattern.charAt(i), i);
			}
			
		}
		
		for(int i=0; i<str.length(); i++)
		{
			if(map2.containsKey(str.charAt(i)))
			{
				int val = map2.get(str.charAt(i));
				s2 += val;
				map2.remove(str.charAt(i));
			}
			else
			{
				s2 += i;
				map2.put(str.charAt(i), i);
			}
		}	
		
		return s1.equals(s2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(isEncoded("abcabc","123321"));
		System.out.println(isEncoded("abcabc","xyzxyz"));
	}

}
