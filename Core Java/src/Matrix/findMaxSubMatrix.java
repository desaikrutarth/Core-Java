package Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, 
 * the maximum sum subarray is highlighted with blue rectangle and sum of this subarray is 29=(-3 + 4 + 2 
 * 																								8 + 10 +1
 * 																							   -1 + 1 + 7).
 */
public class findMaxSubMatrix
{
	public static void main (String[] args) throws java.lang.Exception
    {
		findMaxSubMatrics(new int[][]{
                            {1, 2, -1, -4, -20},
                            {-8, -3, 4, 2, 1},
                            {3, 8, 10, 1, 3},
                            {-4, -1, 1, 7, -6}});
                            					
    }
     
	static int top = 0;
	static int bottom = 0;
    private static void findMaxSubMatrics(int[][] arr)
 	{
 		int rows = arr.length;
 		int cols = arr[0].length;
 		int maxsum = Integer.MIN_VALUE;
 		int topCordinate = 0;
 		int botttomCordinate = 0;
 		int leftCordinate = 0;
 		int rightCordinate = 0;
 		
 		for(int rowIndex = 0; rowIndex < rows; rowIndex++)
 		{
 			int[] colArray = new int[rows];
 			for(int colIndex = rowIndex; colIndex < cols; colIndex++)
 			{
 				for(int i=0; i<colArray.length; i++)
 				{
 					colArray[i] += arr[i][colIndex];
 				}
 				
 				int sumOfCols = getSum(colArray);
 				if(sumOfCols > maxsum)
 				{
 					maxsum = sumOfCols;
 					topCordinate = top;
 			 		botttomCordinate = bottom;
 			 		leftCordinate = rowIndex;
 			 		rightCordinate = colIndex;
 				}
 			}
 		}
 		System.out.println("MaxSum: " + maxsum);
 		
 		System.out.println(""
 				+ "co-ordinates: [(" + leftCordinate + ", " + topCordinate + 
                ")(" + rightCordinate + ", " + botttomCordinate + ")]");
 		
 		System.out.println("subarray:");
 		for(int i=leftCordinate; i<=rightCordinate; i++)
 		{
 			for(int j=topCordinate; j<=botttomCordinate; j++)
 			{
 				System.out.print(arr[i][j]+" ");
 			}
 			System.out.println();
 		}
 	}
 	
 	private static int getSum(int[] colArray)
 	{
 		int maxSumOfCols = Integer.MIN_VALUE;
 		int sum = 0;
 		for(int i=0; i<colArray.length; i++)
 		{
 			sum += colArray[i];
 			if(sum < 0)
 			{
 				sum = 0;
 				top = i+1;
 			}
 			if(sum > maxSumOfCols)
 			{
 				maxSumOfCols = Math.max(maxSumOfCols, sum);
 				bottom = i;
 			}
 			
 		}
 		return maxSumOfCols;
 	}
    /**
     * To find maxSum in 1d array
     * 
     * return {maxSum, left, right}
     */
 /*   public static int[] kadane(int[] a)
    {
        //result[0] == maxSum, result[1] == start, result[2] == end;
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;
     
        for (int i = 0; i < a.length; i++)
        {
            currentSum += a[i];
            if (currentSum < 0) 
            {
                  currentSum = 0;
                localStart = i + 1;
            } 
            else if (currentSum > result[0]) 
            {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
            }
        }
         
        //all numbers in a are negative
        if (result[2] == -1) 
        {
            result[0] = 0;
            for (int i = 0; i < a.length; i++) 
            {
                if (a[i] > result[0]) 
                {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
         
        return result;
      }
    
     //To find and print maxSum, (left, top),(right, bottom)
    public static void findMaxSubMatrics(int[][] a) 
    {
        int cols = a[0].length;
        int rows = a.length;
        int[] currentResult;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
         
        for (int leftCol = 0; leftCol < cols; leftCol++) 
        {
            int[] tmp = new int[rows];
     
              for (int rightCol = leftCol; rightCol < cols; rightCol++)
              {
         
                for (int i = 0; i < rows; i++) 
                {
                      tmp[i] += a[i][rightCol];
                }
                currentResult = kadane(tmp);
                if (currentResult[0] > maxSum)
                {
                    maxSum = currentResult[0];
                    left = leftCol;
                    top = currentResult[1];
                    right = rightCol;
                    bottom = currentResult[2];
                }
            }
        }
              System.out.println("MaxSum: " + maxSum + 
                                ", range: [(" + left + ", " + top + 
                                  ")(" + right + ", " + bottom + ")]");
    }
    */
}
