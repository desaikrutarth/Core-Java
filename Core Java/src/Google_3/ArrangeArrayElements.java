package Google_3;

import java.util.Arrays;

/*
 * Given an array of integers, print all the numbers that meet the following requirement
 * when the number is greater than every number on its left and smaller than every number on the right.
 */
public class ArrangeArrayElements
{
	static void arrangeElements(int[] arr)
	{
		int i = -1;
		int j = 0;
		int pivot = arr[arr.length-1];
		
		for(j = 0; j < arr.length-1; j++)
		{
			if(arr[j] <= pivot)
			{
				i++;
				arr = swap(arr, i , j);
			}
		}
		arr = swap(arr, i+1, j);
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {9,6,5,0,8,2,4,7};
		arrangeElements(arr);
	}
}
