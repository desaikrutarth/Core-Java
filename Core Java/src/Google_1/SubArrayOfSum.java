package Google_1;

import java.util.ArrayList;

/*
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
 * Print indexes of subarray. Complexity should be O(n).
 * Input: 1 2 3 7 5 
 * 	 Sum: 12
 * Output: 2 4
 */
public class SubArrayOfSum
{
	static void subArrays(int arr[], int sum)
	{
		//ArrayList<Integer> list = new ArrayList<>();
		int result = 0;

		int i=0;
		int j=0;
		
		while(i < arr.length && j < arr.length)
		{
			result += arr[j];
			//list.add(result);	
			
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
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 15; 
		SubArrayOfSum.subArrays(arr, sum);
	}
}
