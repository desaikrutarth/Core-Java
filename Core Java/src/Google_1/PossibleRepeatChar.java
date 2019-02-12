package Google_1;

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
		
		HashMap<Character, Integer> hmap = new HashMap<>();
		String result = "";
		for(int i=0; i<str.length(); i++)
			hmap.merge(str.charAt(i), 1, Integer::sum);
		
		int maxVal = 0;
		for(char key: hmap.keySet())
		{
			int val = hmap.get(key);
			if(val > maxVal)
				maxVal = val;
		}
		
		if(maxVal <= str.length()+1/2)
		{
			char[] chArrray = str.toCharArray();		
			for(int i=1; i<chArrray.length; i++)
			{
				if(chArrray[i] == chArrray[i-1] && i < chArrray.length-1)
				{
					char tmp = chArrray[i];
					chArrray[i] = chArrray[i+1];
					chArrray[i+1] = tmp;
				}
			}
			
			result = String.valueOf(chArrray);
			System.out.println("Output is possible: " +result);
		}
		else
			System.out.println("No output possible");
	}
		
	public static void main(String[] args)
	{
		String str = "google";	
		swapChars(str);
	}
}

