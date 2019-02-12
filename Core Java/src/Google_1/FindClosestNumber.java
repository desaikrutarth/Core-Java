package Google_1;

import java.util.HashMap;
import java.util.Stack;

/*
Given an array of sorted integers and find the closest value to the given number. Array may contain duplicate values and negative numbers. 

Example : Array : 2,5,6,7,8,8,9 
Target number : 5 
Output : 5 

Target number : 11 
Output : 9 

Target Number : 4 
Output : 5
 */
public class FindClosestNumber 
{
	static int findNumber(int[] arr,int num)
	{
		int diff = 0;
		int mindiff=Integer.MAX_VALUE;
		int result=0;
		for(int i=0; i<arr.length; i++)
		{
			diff = Math.abs(num - arr[i]);
			
			if(diff < mindiff)
			{
				mindiff = diff;
				result = arr[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {2,5,6,7,8,8,9};
		int num = 11;
		System.out.println(findNumber(arr, num));
	}
}
