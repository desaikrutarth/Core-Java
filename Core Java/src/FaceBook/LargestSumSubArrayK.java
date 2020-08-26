package FaceBook;
/*
Given an array, find the subarray (containing at least k numbers) which has the largest sum.
Examples:
Input : arr[] = {-4, -2, 1, -3} 
            k = 2
Output : -1
The sub array is {-2, 1}
 */
public class LargestSumSubArrayK	
{
	private static int largestSum(int[] arr, int k)
	{
		int sum = 0;
		int maxsum = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length-k; i++)
		{
			for(int j=i; j<i+k; j++)
			{
				sum += arr[j];
			}
			maxsum = Math.max(sum, maxsum);
			sum = 0;
		}
		return maxsum;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {-4, -2, 1, -3};
		System.out.println(largestSum(arr,2));
	}
}
