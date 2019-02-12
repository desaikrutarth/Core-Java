package General;

import java.util.ArrayList;
import java.util.List;
/*
  Given an api which returns an array of chemical names and an array of chemical symbols,
  display the chemical names with their symbol surrounded by square brackets: 

Ex: 
Chemicals array: ['Amazon', 'Microsoft', 'Google'] 
Symbols: ['I', 'Am', 'cro', 'Na', 'le', 'abc'] 

Output: 
[Am]azon, Mi[cro]soft, Goog[le] 

If the chemical string matches more than one symbol, then choose the one with longest length. (ex. 'Microsoft' matches 'i' and 'cro') 
 */
public class MergePartsWords 
{
	static void findMatch(String[] words, String[] parts)
	{
		List<String> list = new ArrayList<String>();
		for(String word : words)
		{
			String result ="";
			for(String part : parts)
			{
				if(word.contains(part))
					result = word.replace(part,"["+part+"]");
			}
			
			if(result.length() == 0)
				result = word;
			list.add(result);
		}
		list.forEach(System.out::println);
		
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] words = {"Amazon", "Microsoft", "Google"};
		String[] parts = {"I", "Am", "cro", "Na", "le", "abc"};
		
		findMatch(words, parts);

	}
}
