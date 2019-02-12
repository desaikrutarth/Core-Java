package Google_3;
/*
 * Given an non-negative int array and target number, check if the target can be equal to the sum of non-negative multiples of the numbers in the array. 
For example, I have three numbers 3,9,20. Ex: n = 47 then it can be determined that 47 = 9*3 + 20 
n=23 then there are no combinations. 
public boolean combinationSum(int[] nums, int target) { 

}
 */
public class CheckTargetSumDP
{
	public static boolean combinationSum(int[] items, int sum) 
	{
		boolean[] possible = new boolean[sum+1];
	    possible[0] = true;
	    for (int i=0; i<=sum; i++)
	    {
	    	if (possible[i])
	    	{
	    		for (int j=0; j<items.length; j++) 
	    		{
	    			if(i+items[j] <= sum) 
	    				possible[i+items[j]] = true;
	    		}
	    	}
	    }
	    return possible[sum];
	  }
	
	public static void main(String[] args) 
	{
		int[] arr = {3,2,20};
		System.out.println(combinationSum(arr,47));
	}
}
