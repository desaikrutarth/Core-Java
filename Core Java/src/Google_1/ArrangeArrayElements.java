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
		int left = 0;
	    int length = arr.length;
	    int mid = (length % 2 == 0)? left + length / 2 : (left + length / 2)+1;
	    int right = mid;
	    
	    int[] result = new int[arr.length];
	    int index=0;
	    
	    while(left < mid && right < length)
	    {
	        result[index++] = arr[left++];
	        result[index++] = arr[right++];
	    }
	    
	    while(left < mid)
	      result[index++] = arr[left++];
	    
		
		System.out.println(Arrays.toString(result));
	}
	
	
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,10,11,12};
		rearrange(arr);
	}
}
