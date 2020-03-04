package Google_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/*
 * Given an integer, figure out the total number of ways to decode it.
 * You are given a dictionary that maps a string with a unique integer n where 0 <= n < 1000.	
	For example,
	‘A’ -> 1
	‘AB’ -> 2
	 .....
	‘ZEX’ -> 221
	
	e.g.
	Input: 221
	Output: 2 (since 221 can be decoded as ‘ZEX’ or ‘ABABA’)
 */
public class DecodeStringGoogle 
{
	
	static int decode(Map<String, Integer> dictionary, int input)
	{
		//Build new Map to store a Value based on Key
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Entry<String, Integer> entry : dictionary.entrySet())
		{
			map.put(entry.getValue(), entry.getKey());
		}
		
		String decode = String.valueOf(input);
		List<String> decodeList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<decode.length(); i++)
		{
			for(int j=i+1; j<=decode.length(); j++)
			{
				String substring = decode.substring(i,j);
				
				if(map.containsKey(Integer.parseInt(substring)))
				{
					String val = map.get(Integer.parseInt(substring));
					
					if(substring.length() == 1)
						sb.append(val);
					else
						decodeList.add(val);
				}
			}
		}
		decodeList.add(sb.toString());
		System.out.println(decodeList);
		
		return decodeList.size();
	}
	
	public static void main(String[] args)
	{
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("A",1);
		hmap.put("AB",2);
		hmap.put("ZEX",221);
		
		int input = 221;
		System.out.println(decode(hmap, input));
	}
}
