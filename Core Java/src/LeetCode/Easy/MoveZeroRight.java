package LeetCode.Easy;

import java.util.Arrays;
/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	Without creating a new array
Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
public class MoveZeroRight
{
	private static void moveZeros(int[] arr) 
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
	}
	public static void main(String[] args)
	{
		int[] arr = {0,1,0,3,12};
		moveZeros(arr);
	}

	
}
