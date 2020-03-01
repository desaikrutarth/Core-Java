package Google_1;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
 * Print indexes of subarray. Complexity should be O(n).
 * Input: 1 2 3 7 5 
 * 	 Sum: 12
 * Output: 1, 3
 * 		   3, 4
 */
public class SubArrayOfSum
{
	static void subArrays(int arr[], int target)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			sum += arr[i];
			map.put(sum, i+1);
			if(map.containsKey(sum-target))
				System.out.println((map.get(sum-target)) +", "+(i));
		}
	}
	
	/*static void subArrays(int arr[], int sum)
	{
		int result = 0;

		int i=0;
		int j=0;
		
		while(i < arr.length && j < arr.length)
		{
			result += arr[j];
			
			if(result == sum)
				System.out.println((i+1)+","+(j+1));
			
			if(j == arr.length-1)
			{
				i++;
				j = i+1;
				result = arr[i];
			}
			else
				j++;
							
		}		
	}*/
	
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 7, 5};
		int sum = 12; 
		SubArrayOfSum.subArrays(arr, sum);
	}
}
