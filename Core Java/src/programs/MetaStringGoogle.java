package programs;

import java.util.LinkedHashMap;

public class MetaStringGoogle
{
	static void metaString(String str1, String str2)
	{
		LinkedHashMap<Character, Integer> hmap1 = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> hmap2 = new LinkedHashMap<>();
		
		int count=1;
		for(int i=0; i<str1.length(); i++)
		{
			hmap1.put(str1.charAt(i), count);
			count++;
		}
		
		count =1;
		for(int i=0; i<str2.length(); i++)
		{
			hmap2.put(str2.charAt(i), count);
			count++;
		}

		int cnt = 0;
		for(Character ch : hmap1.keySet())
		{
			if(hmap2.containsKey(ch))
			{
				int val1 = hmap1.get(ch);
				int val2 = hmap2.get(ch);
				if(val1 != val2)
					cnt++;

			}
		}
		if(cnt == 2)
			System.out.println(1);
		else
			System.out.println(0);
	}
	public static void main(String[] args)
	{
		String str1 = "geeks";
		String str2 = "ekegs";
		MetaStringGoogle.metaString(str1, str2);
	}
}
