package Google_3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/*
Give a list of the company's Mergers and Acquisitions relationships, for example 
[ 
["baidu", "ofo"], 
["mobike", "alibaba"], 
] 
Said baidu acquired ofo, mobike acquired Alibaba. 
Seeking the longest of a M & A chain. No cycle
 */
public class CompanyRelationship
{
	static int longestChain(LinkedHashMap<String, String> map)
	{
        int max = 0;
        int count = 0;
        for (String key : map.keySet())
        {
            count = 1;
            String val = map.get(key);
            while(map.containsKey(val))
            {
                count++;
                val = map.get(val);
            }
            max = Math.max(count, max);
        }

        return max;
    }
	public static void main(String[] args)
	{
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("beidu", "ofo");
		map.put("cookies", "mobike");
		map.put("mobike", "alibaba");
		map.put("alibaba", "somethingElse");
		
		System.out.println(longestChain(map));
	}
}
