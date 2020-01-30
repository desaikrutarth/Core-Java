package LeetCode.Easy;
/*
 Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */

import java.util.Arrays;

public class SortByOddEven
{
	
	public static Integer[] sortArrayByParity(Integer[] A)
	{
		/*Arrays.sort(A,(a,b) -> {
			if(a%2 == 0)
				return -1;
			if(b%2 == 0)
				return 1;
			return a;
		});*/
		
		Arrays.sort(A, (a, b) -> Integer.compare(a%2, b%2));
		 
		return A;
	}
	
	public static void main(String[] args)
	{
		Integer[] A = {3,1,2,4,5,6,7,8};
		System.out.println(Arrays.toString(sortArrayByParity(A)));
	}
}
