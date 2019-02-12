package Google_1;

/* Given an array. calculate maximum sum of subarray */
public class LargestSumSubarray
{	 
	 static int maxSubArraySum(int a[])
	 {
	        int maxSum = a[0];
	        int sum = 0;
	 
	        for (int i = 0; i < a.length; i++)
	        {
	            sum += a[i];
	            if (sum > maxSum)
	                maxSum = sum;
	            if (sum < 0)
	                sum = 0;
	        }
	        return maxSum;
	 }
	 
	 public static void main (String[] args)
	 {
	        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	        System.out.println("Maximum contiguous sum is " +maxSubArraySum(a));
	 }
}
