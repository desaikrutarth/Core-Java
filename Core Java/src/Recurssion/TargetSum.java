
package Recurssion;
import java.util.Stack;
/* Given an array. find all possible pairs with target sum*/
public class TargetSum
{	
	Stack<Integer> stack = new Stack<Integer>();
	public void findSubsetWithTargetSum(int[] arr, int index, int sum)
	{
		if (sum == 0) 
		{
			System.out.println(stack);
			return;
		} 
		else if (index < arr.length)
		{
			// Select INPUT[startIndex] and find subset from startIndex+1 with target sum-INPUT[startIndex]
			int element = arr[index];
			if (sum >= element) 
			{
				stack.push(element);
				findSubsetWithTargetSum(arr, index + 1, sum - element);
				stack.pop();
			}
			// Find subset from startIndex+1 with target sum
			findSubsetWithTargetSum(arr, index + 1, sum);
		}
	}

	// Return true if array contains all possible pairs with target sum. else return false
	/*public boolean findSubsetWithTargetSum(int[] arr, int index, int sum)
	{
		if(sum == 0)
			return true;
		
		if(index < arr.length)
		{
			if(arr[index] <= sum)
			{
				if(findSubsetWithTargetSum(arr, index+1, sum-arr[index]))
					return true;
			}
			
			if(findSubsetWithTargetSum(arr, index+1, sum))
				return true;
		}
		return false;
	}*/
	
	public static void main(String[] args)
	{
		TargetSum sum = new TargetSum();
		
		int[] arr = {1, 3, 4, 5, 6, 15};
		int TARGET_SUM = 15;
		sum.findSubsetWithTargetSum(arr, 0, TARGET_SUM);
	}
}
