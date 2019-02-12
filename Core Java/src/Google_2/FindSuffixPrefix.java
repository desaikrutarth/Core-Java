package Google_2;

import java.util.HashMap;
/*
input: words [['google', 30], ['gogle', '20'], ...] 
queries [['go, le'], ...] 
output: [30, 20 .....] 
The query is suffix and prefix, giving the maximum match.
 */
public class FindSuffixPrefix 
{
	static void getSuffixPrefix(HashMap<String, Integer> wordMap, HashMap<String, String> queriesMap)
	{
		for(String word : wordMap.keySet())
		{
			for(String prefix : queriesMap.keySet())
			{
				String suffix = queriesMap.get(prefix);
				if(word.startsWith(prefix) && word.endsWith(suffix))
					System.out.println(wordMap.get(word));
			}
		}
	}
	
	public static void main(String[] args)
	{
		HashMap<String, Integer> word = new HashMap<>();
		word.put("google",30);
		word.put("gogle", 20);
		word.put("facebook",10);
		word.put("microsoft",15);
		word.put("amazon", 5);
		
		HashMap<String, String> queries = new HashMap<>();
		queries.put("go", "le");
		queries.put("fa", "ok");
		queries.put("mi", "soft");
		
		getSuffixPrefix(word, queries);
	}
}
