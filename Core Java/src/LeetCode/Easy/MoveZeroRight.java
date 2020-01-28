package LeetCode.Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	Without creating a new array
Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
public class MoveZeroRight
{
	private static void moveZeros(Integer[] arr) 
	{
		Arrays.sort(arr,(a,b)->{
			if(a == 0)
				return 1;
			if(b == 0)
				return -1;
			return a;
		});
		System.out.println(Arrays.toString(arr));
	}
	
	/*private static void moveZeros(Integer[] arr) 
	{
		int index=0;
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] != 0)
				arr[index++] = arr[i];
		}
		
		while(index < arr.length)
			arr[index++] = 0;
		
		System.out.println(Arrays.toString(arr));
	}*/
	
	
	public static void main(String[] args)
	{
		Integer[] arr = {0,5,0,3,12};
		moveZeros(arr);
	}

	
}
