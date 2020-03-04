package Google_2;

import java.util.HashMap;
/*
 Example: pattern = 'abcabc' 
				s = '123123' -> True 
				s = 'cbzabc' -> False 
				s = 'xyzxyz' -> True 
 */
public class PatternChecker
{
	public static boolean checkPattern(String pattern, String str)
	{
		HashMap<Character, Character> map = new HashMap<>();

		if(pattern.length() != str.length())
			return false;

		for(int i=0; i<pattern.length(); i++)
		{
			char c1 = pattern.charAt(i);
			char c2 = str.charAt(i);

			if(map.containsKey(c1))
			{
				if(map.get(c1) !=  c2) 
					return false;
			}
			else
			{
				if(map.containsValue(c2)) // If more than one key has same value
					return false;
				map.put(c1, c2);
			}
		}
		return true;
	}

//	static boolean isEncoded(String pattern, String str) 
//	{
//		HashMap<Character, Integer> map = new HashMap<>();
//		String s1 = "";
//		String s2 = "";
//		
//		for(int i=0; i<pattern.length(); i++)
//		{
//			if(map.containsKey(pattern.charAt(i)))
//			{
//				int val = map.get(pattern.charAt(i));
//				s1 += val;
//				map.remove(pattern.charAt(i));
//			}
//			else
//			{
//				s1 += i;
//				map.put(pattern.charAt(i), i);
//			}
//			
//		}
//		
//		for(int i=0; i<str.length(); i++)
//		{
//			if(map.containsKey(str.charAt(i)))
//			{
//				int val = map.get(str.charAt(i));
//				s2 += val;
//				map.remove(str.charAt(i));
//			}
//			else
//			{
//				s2 += i;
//				map.put(str.charAt(i), i);
//			}
//		}	
//		return s1.equals(s2);
//	}
	
	public static void main(String[] args)
	{
		System.out.println(checkPattern("abcabc","123321"));
		System.out.println(checkPattern("abcabc","xyzxyz"));
	}

}
