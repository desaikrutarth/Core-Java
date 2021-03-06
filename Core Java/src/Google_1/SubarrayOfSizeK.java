package Google_1;

import java.util.ArrayDeque;
import java.util.Deque;
/*
 * Find the minimum of every sub-array of size k in an array of size n. 
Example:
	Array = {23, 1, 4, 17, 5, 6, 8}
	k = 3
	
	Output: {23, 1, 4}= 1
		    {1, 4, 17}= 1
            {4, 17, 5}= 4
            {17, 5, 6}= 5
			{5, 6, 8} = 5
 */
public class SubarrayOfSizeK 
{
	public static void MinSlideArray(int arr[], int k)
	{
		for(int i=0; i<=arr.length-k; i++)
		{
			int min=arr[i];
			for(int j=i; j<i+k; j++)
			{
				min = Math.min(min, arr[j]);
			}
			System.out.println(min);
		}
	}
	
/*	public static void MinSlideArray(int arr[], int k)
	{
		int count = 0;
		int left = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++)
		{
			count++;
			min = Math.min(min, arr[i]);
			
			if(count == k)
			{
				left++;
				i = left-1;
				count = 0;
				System.out.println(min);
				min = Integer.MAX_VALUE;
			}
			
		}
	}
*/	
	public static void main(String[] args)
	{
		int[] arr = {23, 1, 4, 17, 5, 6, 8};
		int k=3;
		MinSlideArray(arr, k);
	}
}
