package Google_1;

import java.util.HashMap;

/*
Define a function that can detect whether the characters of a string can be shuffled without repeating same characters as one other's neighbors.
E.g. :
apple >> alpep, so valid 
a >> a, valid 
aa >> aa, invalid/impossible 
aab >> aba, valid 
aaaabbcc >> acabacab, valid 
etc. 
You do not have to find one representation, just have to detect if it is possible or not!
 */
public class ShuffleCharWithoutRepeat 
{
	public static boolean canShuffle(String str) 
	{
		HashMap<Character, Integer> hmap = new HashMap<>();
		for(int i=0; i<str.length(); i++)
		{
			hmap.merge(str.charAt(i), 1, Integer::sum);
		}
		
		int maxval = 0;
		for(char key : hmap.keySet())
		{
			int val = hmap.get(key);
			if(val > maxval)
				maxval = val;
		}
		
		if(maxval <= (str.length()+1) / 2)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args)
	{
		boolean b = canShuffle("apple");
		if(b)
			System.out.println("valid");
		else
			System.out.println("Invalid");
	}
}
