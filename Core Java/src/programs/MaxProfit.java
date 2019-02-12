package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, 
the maximum profit can earned by buying on day 0, selling on
day 3. Again buy on day 4 and sell on day 6. 
If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.*/
public class MaxProfit
{
	public void getMaxProf(int[] arr)		//Method without sorting O(n)
	{
		int left = 0;
		int maxProfit = Integer.MIN_VALUE;
		
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] > arr[i-1])
			{
				int diff = arr[i] - arr[left];
				if(diff > maxProfit)
					maxProfit = diff;
			}
			else
			{
				left = i;
			}
		}
		
		if(maxProfit < 0)	//Array is in descending order
			maxProfit = 0;
		System.out.println(maxProfit);
	}
	
	public static void main(String[] args)
	{
		int arr[] = {100, 180, 260, 310, 40, 535, 695};
		MaxProfit max = new MaxProfit();
		max.getMaxProf(arr);
	}
}
