package Google_3;

import java.util.HashMap;
import java.util.Stack;

/*
 * For a string chemical formula like “C6H2(NO2)3CH3”, and output a map with key as element and value as its count. 
element can have two chars, for example Fe2(SO4)3 
public HashMap<Character, Integer> getCount(String chemicals){ 
}
 */
public class ChemicalFormulaCount
{
	static HashMap<Character, Integer> getCount(String chemicals)
	{ 
		HashMap<Character, Integer> hmap = new HashMap<>();
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<chemicals.length(); i++)
		{
			char ch = chemicals.charAt(i);
			
			if(Character.isDigit(ch))
			{
				String pop = stack.pop();
				StringBuilder str = new StringBuilder();
				int num = Integer.parseInt(String.valueOf(ch));
				for(int j=0; j<num; j++)
					str.append(pop);
				stack.push(str.toString());
			}
			else if(ch == ')')
			{
				StringBuilder str = new StringBuilder();
				String pop = "";
				while(!(pop =stack.pop()).equals("("))
				{
					str.insert(0, pop);
				}
				stack.push(str.toString());
			}
			else
				stack.push(String.valueOf(ch));		
		}
		
		StringBuilder result = new StringBuilder();
		
		while(stack.size() != 0)
			result.insert(0, stack.pop());
	
		System.out.println(result.toString());
		
		for(char ch : result.toString().toCharArray())
			hmap.merge(ch, 1, Integer::sum);
		
		return hmap;
	}
	
	public static void main(String[] args)
	{
		String str = "C6H2(NO2)3CH3";
		HashMap<Character, Integer> hmap = getCount(str);
		System.out.println(hmap);
	}
}
