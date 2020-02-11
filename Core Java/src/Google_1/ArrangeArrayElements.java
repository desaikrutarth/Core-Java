package Google_1;

import java.util.Arrays;

/*
 * Given an array like {a1,a2,a3,...an,b1,b2,b3,...bn}
 * Arrange an array in order of {a1,b1,a2,b2,a3,b3,....an,bn}
 * 
 * [1, 13, 2, 12, 3, 11, 4, 10]
 */

public class ArrangeArrayElements 
{
	public static void rearrange(int[] arr) 
	{
		if (arr == null || arr.length % 2 == 1)
	    	return;
		
		int[] result = new int[arr.length];
		int index =0;

		int left = 0;
		int mid = arr.length / 2;
		int right = mid;

		while(left < mid && right < arr.length)
		{
			result[index++] = arr[left];
			result[index++] = arr[right];

			left++;
			right++;
		}
		
		System.out.println(Arrays.toString(result));
	}
	
	/*	public static void rearrange(int[] arr) 
	{
		int lb = 0;
		int ub = arr.length-1;
		int mid = (ub + lb) / 2 ;
		
		int[] result = new int[arr.length];
		int index =0;
		int i=lb;
		int j =mid+1;
		
		while(i <= mid && j <= ub)
		{
			result[index++] = arr[i++];
			result[index++] = arr[j++];
		}
		
		if(i != mid+1)
		{
			for(int k=i; k<mid+1; k++)
				result[index++] = arr[k++];
		}

		System.out.println(Arrays.toString(result));
	}
	*/
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,10,11,12,13};
		rearrange(arr);
	}
}
