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
		HashMap<Character, Integer> hmap = new HashMap<>();
		
		for(int i=0; i<s2.length(); i++)
			hmap.merge(s2.charAt(i), 1, Integer::sum);
		
		for(int i=0; i<s1.length(); i++)
		{
			char ch = s1.charAt(i);
			if(hmap.containsKey(ch))
			{
				int val = hmap.get(ch);
				if(val > 1)
					hmap.put(ch, --val);
				else
					hmap.remove(ch);
			}
		}
		return hmap.keySet().toString().charAt(1);
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
