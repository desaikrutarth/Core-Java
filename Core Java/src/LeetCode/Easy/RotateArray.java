package LeetCode.Easy;

import java.util.Arrays;
/*
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray 
{
	private static void rotateArray(int[] arr, int k)
	{
		while(k-- > 0)
		{
			
			int[] newArray = new int[arr.length];
			newArray[0] = arr[arr.length-1];
			int newArrIndex = 1;
			for(int i=0; i<arr.length-1; i++)
			{
				newArray[newArrIndex++] = arr[i];
			}
			arr = newArray;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7};
		rotateArray(arr,3);

	}

}
