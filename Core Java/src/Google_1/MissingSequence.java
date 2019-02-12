package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

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
	static void sequence(List<Integer> Inputlist)
	{
		LinkedHashMap<Integer, List<Integer>> hmap = new LinkedHashMap<>();
		int index = 0;
		for(int i=0; i<100; i++)
		{
			List<Integer> list = new ArrayList<>();
			if(!Inputlist.contains(i))
			{
				if(hmap.containsKey(index))
					list = hmap.get(index);					
				
				list.add(i);
				hmap.put(index, list);			
			}
			else
				index++;
		}
		
		int start = 0;
		int end =0;
		int count = 0;
		String result = "";
		for(int key : hmap.keySet())
		{
			List<Integer> list = hmap.get(key);
			for(int item: list)
			{
				count++;
				if(count == 1)
					start = item;
				else
					end = item;
			}
			String first = String.valueOf(start);
			String last = String.valueOf(end);
			
			if(count == 1)
				result = first;
			else
				result = first + "-" + last;
		
			count = 0;
			System.out.println(result);
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
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 50, 52, 75));
		MissingSequence.sequence(list);
	}
}
