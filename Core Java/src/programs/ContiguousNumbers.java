package programs;

import java.util.*;
/*
 * Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous integers else print “No”.
 * Test Case 1 : The elements  of array form a contiguous set of integers which is {2, 3, 4, 5, 6} so the output is "Yes".
   Test Case 2: The elements of array {10,14,10,12,12,13,15}which is unable to form contiguous set of integers so output is "No".
 */
public class ContiguousNumbers
{
	static boolean isContiguous(int[] arr)
	{
		Arrays.sort(arr);
		for(int i=1; i<arr.length; i++)
		{
			int diff = arr[i] - arr[i-1];
			if(diff > 1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {10,14,10,12,12,13,15,11};
		System.out.println(isContiguous(arr));
	}
}
