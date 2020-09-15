package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* print missing numbers from given array*/
/*
 * Summarize gaps in a list. 
Given a sorted list of distinct integers from 0 to 99. Your task is to produce a string that describes numbers
missing from the list sorted in ascending order and separated by commas.
When a gap spans only one number, the item is the number itself; when a gap is longer,
the item comprises the start and the end of the gap, joined with a minus sign.
For example,
 	if the input is [0, 1, 2, 50, 52, 75],
 	the output should be "3-49,51,53-74,76-99".

 */

public class MissingSequence
{
	public static void sequence(List<Integer> inputList)
	{
	    Map<Integer, List<Integer>> map = new LinkedHashMap<>();
	    int key=0;
	    
	    for(int i=0; i<=99; i++)
	    {
	        if(!inputList.contains(i))
	        {
	            map.computeIfAbsent(key, (list)->new ArrayList<>());
	            map.get(key).add(i);
	        }
	        else
	            key = i;
	    }
	    
	    for(List<Integer> valList : map.values())
	    {
	        String result = "";
	    
	        if(valList.size() == 1)
	        	result = "" + valList.get(0);
	        else
	        	result = valList.get(0)+ "-" +valList.get(valList.size()-1);
	        
	        System.out.println(result);
	    }
	}
		
/*		static void sequence(int[] arr)
		{
			for(int i=1; i<arr.length; i++)
			{
				int current = arr[i];
				int prev = arr[i-1];
				
				if(current - prev > 2)
				{
					int p = prev+1;
					int c = current-1;
					System.out.println(p+"-"+c);
				}
				else if (current - prev == 2)
				{
					int p = prev+1;
					System.out.println(p);
				}
				
				if(i == arr.length-1)
				{
					int p = arr[arr.length-1] +1;
					System.out.println(p+"-"+99);
				}
			}*/
	
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 50, 52, 75));
		sequence(list);
	}
}
