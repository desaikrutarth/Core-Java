package programs;

import java.util.HashMap;

public class DuplicateCharacters 
{
	public static void main(String[] args)
	{
		String str = "hellohe";
		char[] ch = str.toCharArray();
		HashMap<Character, Integer> hmap = new HashMap<Character,Integer>();
		
		for(int i=0; i<ch.length; i++)
		{
			hmap.merge(ch[i], 1, Integer::sum);
		}
		
		for(Character c : hmap.keySet())
		{
			if(hmap.get(c) > 1)
				System.out.println(c);
		}
		
		
	}
		
		
}
