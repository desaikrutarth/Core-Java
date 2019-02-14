package Google_1;

import java.util.Arrays;
/*
Implement the plusplus operator when we are getting the input as integer array = { 9,9,9,9 }.output will be {1,0,0,0,0}
*/
public class ArrayIncrement
{
	static int[] incrementArr(int arr[], int length)
	{
		if(length == 0)
		{
			int[] newArr = new int[arr.length+1];
			newArr[0]++;
			return newArr;
		}
		else if(arr[length] == 9)
		{
			arr[length] = 0;
			length--;
			arr = incrementArr(arr, length);
		}
		else
		{
			arr[length]++;
		}
		return arr;
	}
	
	public static void main(String[] args)
	{
		int arr[] = {9,9,9,9};
		int arrLength = arr.length-1;
		int[] result = incrementArr(arr, arrLength);
		System.out.println(Arrays.toString(result));
	}
	
}


