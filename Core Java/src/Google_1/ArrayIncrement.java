package Google_1;

import java.util.Arrays;
/*
Implement the plusplus operator when we are getting the input as integer array = { 9,9,9,9 }.output will be {1,0,0,0,0}
*/
public class ArrayIncrement
{
	static int[] incrementArr(int arr[], int length)
	{
		for(int i=arr.length-1; i>=0; i--)
		{
			if(arr[i] != 9)
			{
				arr[i]++;
				return arr;
			}	
			arr[i] = 0;
		}
		
		int[] newArray = new int[arr.length+1];		//if all numbers are 9
		newArray[0] = 1;
		return newArray;
	}
	
	/*static int[] incrementArr(int arr[], int length)
	{
		if(length == 0)
		{
			if(arr[length] == 9)
			{
				int[] newArr = new int[arr.length+1];
				newArr[0]++;
				return newArr;
			}
			else
			{
				arr[length]++;
				return arr;
			}
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
	}*/
	
	public static void main(String[] args)
	{
		int arr[] = {8,9,9,9};
		int arrLength = arr.length-1;
		int[] result = incrementArr(arr, arrLength);
		System.out.println(Arrays.toString(result));
	}
	
}


