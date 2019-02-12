package General;

import java.util.LinkedHashMap;

/*
Given an input string and ordering string, need to return true if the ordering string is present in Input string. 

input = "hello world!" 
ordering = "hlo!" 
result = FALSE (all Ls are not before all Os) 

input = "hello world!" 
ordering = "!od" 
result = FALSE (the input has '!' coming after 'o' and after 'd', but the pattern needs it to come before 'o' and 'd') 

input = "hello world!" 
ordering = "he!" 
result = TRUE 

input = "aaaabbbcccc" 
ordering = "ac" 
result = TRUE
*/
public class CheckOrdersOfString
{
	static boolean checkOrder(String input, String order)
	{
		LinkedHashMap<Character, Integer> inputMap = new LinkedHashMap<>();
		
		for(int i=0; i<input.length(); i++)
		{
			if(inputMap.containsKey(input.charAt(i)))
				inputMap.remove(input.charAt(i));
			inputMap.put(input.charAt(i), i);
		}
				
		for(int i=1; i<order.length(); i++)
		{
			char current = order.charAt(i);
			char prev = order.charAt(i-1);
			if(inputMap.containsKey(current) && inputMap.containsKey(prev))
			{
				int currentVal = inputMap.get(current);
				int prevVal = inputMap.get(prev);
				
				if(currentVal < prevVal)
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String input = "hello world!";
		String order = "hlo!";
		System.out.println(checkOrder(input,order));
	}
}
