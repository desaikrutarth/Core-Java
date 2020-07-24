package LeetCode.Easy;

import java.util.Arrays;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]

Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray 
{
	private static void rotateArray(int[] arr, int k)
	{
		while(k-- > 0)
		{
			int index=0;
			int[] newArr = new int[arr.length];
			newArr[index++] = arr[arr.length-1];
			
			for(int i=0; i<arr.length-1; i++)
			{
				newArr[index++] = arr[i];
			}
			arr = newArr;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7};
		rotateArray(arr,3);
	}

}
