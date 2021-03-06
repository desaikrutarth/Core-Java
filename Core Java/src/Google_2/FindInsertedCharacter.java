package Google_2;

import java.util.HashMap;
import java.util.Set;

/*
 * Two Strings are given S1 and S2. one character is added in S2.
 * Find inserted character from S2 
 */
public class FindInsertedCharacter
{
	public static char findInsertedChar(String s1, String s2) 
	{
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char ch : s1.toCharArray())
			map.merge(ch, 1, Integer::sum);
		
		for(char ch : s2.toCharArray())
		{
			if(map.containsKey(ch))
			{
				if(map.get(ch)>1)
					map.put(ch, map.get(ch)-1);
				else
					map.remove(ch);
			}
			else
				return ch;
		}
		
		return ' ';
	}
	
	/*public static char findInsertedChar(String s1, String s2) 
	{
	    int low = 0, high = s1.length() - 1;

	    while (low <= high)
	    {
	        int mid = low + (high - low) / 2;
	        char c1 = s1.charAt(mid);
	        char c2 = s2.charAt(mid);

	        if (c1 == c2) 
	            low = mid + 1; // find char on right-hand side
	        else if (mid == 0 || s1.charAt(mid - 1) != c2) 
	            return c2;
	        else 
	            high = mid - 1; // find char on left-hand side
	        
	    }

	    return s2.charAt(high + 1);
	}*/
	
	public static void main(String args[]) 
	{	 
		System.out.println(findInsertedChar("gogle","google"));
	}
}
