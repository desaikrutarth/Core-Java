package programs;

import java.util.*;

public class StringSplit 
{
	
	public static void main(String[] args)
	{
		String s = "welcometojava";
		String smallest = "";
		String largest = "";
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= s.length() - 3; i++) 
		{
		    String substr = s.substring(i, i + 3);
		    if (substr.matches("[a-zA-Z]+")) 
		    { 
		    	list.add(substr); 
		    }
		}
		
		for(int i = 0; i < list.size()-1; i++)
		{
			for(int j = i+1; j < list.size(); j++)
			{
				smallest = list.get(i);
				largest = list.get(j);
				
				if(smallest.compareTo(largest) < 0)
				{
					System.out.println(smallest);
			
				}
			}			
		}

    }

}
