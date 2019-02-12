package programs;

import java.util.HashMap;
import java.util.regex.Pattern;

public class WordCount
{
	public static void main(String[] args)
	{
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		String str = "Hello Hello How are you";
		String splitt[] = str.split(" ");
		for(String s: splitt)
		{
			if(hmap.containsKey(s))
			{
				int i = hmap.get(s);
				i++;
				hmap.put(s,i);
			}
			else
			{
				hmap.put(s,1);
			}
		}
		System.out.println(hmap);
	}
}
