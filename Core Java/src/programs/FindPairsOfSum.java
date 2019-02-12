package programs;

import java.util.Arrays;

/*
 * Given two unsorted arrays A[] of size n and B[] of size m of distinct elements, 
 * the task is to find all pairs from both arrays whose sum is equal to x.
 * Examples:

	Input : A[] = {-1, -2, 4, -6, 5, 7}
         	B[] = {6, 3, 4, 0}  
         	x = 8
	Output : 4 4, 5 3

	Input : A[] = {1, 2, 4, 5, 7} 
        	B[] = {5, 6, 3, 4, 8}  
        	x = 9
	Output : 1 8, 4 5, 5 4
 */
public class FindPairsOfSum
{
	static void findPairs(int[] A, int[] B, int sum)
	{
		int aIndex=0;
		int bIndex=0;
		
		while(aIndex < A.length && bIndex < B.length)
		{
			if(A[aIndex] + B[bIndex] == sum)
			{
				System.out.println(A[aIndex]+","+B[bIndex]);
			}	
			
			if(bIndex == B.length-1)
			{
				bIndex=0;
				aIndex ++;
			}
			else
			{
				bIndex++;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		
		int[] A = {1, 2, 4, 5, 7};
		int[] B = {5, 6, 3, 4, 8};
		int sum = 9;
		
		FindPairsOfSum.findPairs(A, B, sum);
	}
}
