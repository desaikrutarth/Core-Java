package Google_1;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given a string, check if it is can be reorganized such that the same char is not next to each other, If possible, output a possible result 
example: 
	input: google 
	one possible output: gogole
 */
public class PossibleRepeatChar 
{
	static void swapChars(String str)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char ch: str.toCharArray())
			map.merge(ch, 1, Integer::sum);
		
		int maxnum = Integer.MIN_VALUE;
		
		for(int i : map.values())
			maxnum = Math.max(i, maxnum);
		
		int len = (str.length()+1)/2;
		
		if(maxnum <= len)
		{
			char[] chArr = str.toCharArray();
			for(int i=1; i<chArr.length; i++)
			{
				if(chArr[i] == chArr[i-1] && i < chArr.length-1)
				{
					char tmp = chArr[i];
					chArr[i] = chArr[i+1];
					chArr[i+1] = tmp;
				}
			}
			System.out.println("Output is possible = "+String.valueOf(chArr));
		}
		else
			System.out.println("No output possible");
	}
		
	public static void main(String[] args)
	{
		String str = "gooole";	
		swapChars(str);
	}
}

