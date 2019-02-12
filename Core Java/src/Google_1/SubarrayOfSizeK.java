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
	
	/* Method 2
	int j, min;
	 
   for (int i = 0; i <= n - k; i++) 
   {           
       min = arr[i];

       for (j = 1; j < k; j++) 
       {
           if (arr[i + j] < min)
               min = arr[i + j];
       }
       System.out.print(min + " ");
   }
   */
	
	/* Method 3
	static void MinSlideArray(int[] arr, int k)
	{
	int pos = k;
	int result = Integer.MAX_VALUE;
	for(int i=0; i<arr.length-k+1; i++)
	{
		int j=i;
		while(j < pos)
		{
			int min = Math.min(arr[i], arr[j]);
			if(min < result)			
				result = min;
			
			if(j == pos-1)
			{
				pos = i+k;
				break;
			}
				
			else
				j++;
				
		}
		System.out.println(result);
		result = Integer.MAX_VALUE;
	}
	 * 
	 */
	
	public static void main(String[] args)
	{
		int[] arr = {23, 1, 4, 17, 5, 6, 8};
		int k=3;
		MinSlideArray(arr, k);
	}
}
