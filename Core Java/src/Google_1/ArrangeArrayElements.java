package Google_1;

import java.util.Arrays;

/*
 * Given an array like {a1,a2,a3,...an,b1,b2,b3,...bn}
 * Arrange an array in order of {a1,b1,a2,b2,a3,b3,....an,bn}
 */

public class ArrangeArrayElements 
{
	public static void rearrange(int[] arr) 
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
	
	/* Method 2:
	public static void rearrange(int[] arr) 
	{
	    if (arr == null || arr.length % 2 == 1)
	    	return;

	    int currIdx = (arr.length - 1) / 2;
	    while (currIdx > 0)
	    {
	        int count = currIdx;
	        int swapIdx = currIdx;

	        while (count > 0)
	        {
	            int temp = arr[swapIdx + 1];
	            arr[swapIdx + 1] = arr[swapIdx];
	            arr[swapIdx] = temp;
	            swapIdx++;
	            count--;
	        }

	        currIdx--;
	    }
	    System.out.println(Arrays.toString(arr));
	}*/
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,10,11,12,13};
		rearrange(arr);
	}
}
