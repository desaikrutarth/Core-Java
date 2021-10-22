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
		Stack<String> stack = new Stack<>();
		for(int i=0; i<chemicals.length(); i++)
		{
			char ch = chemicals.charAt(i);
			if(Character.isDigit(ch))
			{
				StringBuilder sb = new StringBuilder();
				while(i<chemicals.length() && Character.isDigit(ch = chemicals.charAt(i)))
				{
					sb.append(ch);
					i++;
				}
				int num = Integer.parseInt(sb.toString());
				if(!stack.isEmpty())
				{
					String pop = stack.pop();
					StringBuffer sf = new StringBuffer();
					for(int j=0; j<num; j++)
						sf.append(pop);
					stack.push(sf.toString());
				}
				i--;
			}
			else if(ch == ')')
			{
				if(!stack.isEmpty())
				{
					StringBuilder sb = new StringBuilder();
					String pop;
					while(!(pop = stack.pop()).equals("("))
						sb.insert(0,pop);
					stack.push(sb.toString());
				}
			}
			else
				stack.push(String.valueOf(ch));
		}
		
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty())
			result.insert(0,stack.pop());
		
		System.out.println(result.toString());
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch : result.toString().toCharArray())
			map.merge(ch, 1, Integer::sum);
		return map;
	}
	
	public static void main(String[] args)
	{
		String str = "C10H2(NO2)3CH3";
		HashMap<Character, Integer> hmap = getCount(str);
		System.out.println(hmap);
	}
}
