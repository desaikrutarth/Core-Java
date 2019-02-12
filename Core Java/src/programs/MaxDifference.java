package programs;

import java.util.Arrays;

//Given an array,find the maximum j – i such that arr[j] > arr[i]

public class MaxDifference
{
	public int maxDifference(int[] arr)   // Method 1: Complexity = O(n)
	{
		Arrays.sort(arr);
		int first = arr[0];
		int maxDiff = arr[1] - arr[0];
		
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > first)
			{
				int diff = arr[i] - first;
				if(diff > maxDiff)
					maxDiff = arr[i] - first;
			}
		}
		return maxDiff;
	}
	
	public int maxDifference2(int[] arr)		// Method 2: Complexity = O(n)
	{
		Arrays.sort(arr);
		int i=0;
		int j= i+1;
		int maxDiff = 0;
		while(i < arr.length && j < arr.length)
		{		
			int diff = arr[j] - arr[i];
			if(diff > maxDiff)
				maxDiff = diff;
		
			if(j == arr.length-1)
			{
				i++;
				j = i+1;
			}
			else
				j++;
		}
		return maxDiff;
	}
	
	public static void main(String[] args)
	{
		MaxDifference max = new MaxDifference();
		int[] arr = {10,8,7,6,5};
		int answer = max.maxDifference(arr);
		System.out.println("Maximum differance = "+answer);
		
	}
	
}
