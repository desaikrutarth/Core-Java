package HackerRank;
/*
 Given a  2D Array, Find maximum Hourglass sum of the array.
 Hourglass sum is defined as, a b c
  							    d
							  e f g
Input: 

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Output: 19

Explanation:
Array contains following Hourglasses: 
1 1 1  1 1 0  1 0 0  0 0 0		<-- 1st Row
  1		 0      0      0
1 1 1  1 1 0  1 0 0  0 0 0 

0 1 0  1 0 0  0 0 0  0 0 0		<-- 2nd Row
  1      1      0      0
0 0 2  0 2 4  2 4 4  4 4 0

1 1 1  1 1 0  1 0 0  0 0 0		<-- 3rd Row
  0		 2		4      4
0 0 0  0 0 2  0 2 0  2 0 0

0 0 2  0 2 4  2 4 4	 4 4 0		<-- 4th Row
  0		 0		2	   0
0 0 1  0 1 2  1 2 4	 2 4 0

So, The Hourglass with the maximum sum is: 19 => 2 4 4	
  											 	   2
										   		 1 2 4	


 */
public class MaxHourglassSumMatrix
{
	public static int findSum(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0; i<rows-2; i++)
		{
			for(int j=0; j<cols-2; j++)
			{
				int sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] 
						+ matrix[i+1][j+1]
					    + matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
				
				maxSum = Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}
	public static void main(String[] args)
	{
		int[][] matrix = {{1,1,1,0,0,0},
				   		  {0,1,0,0,0,0},
				          {1,1,1,0,0,0},
				          {0,0,2,4,4,0},
				          {0,0,0,2,0,0},
				          {0,0,1,2,4,0}};
		
		System.out.println("Maximum Hourglass Sum = "+findSum(matrix));
	}
}
