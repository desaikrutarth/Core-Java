package LeetCode.Medium;

import java.util.Stack;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ['1','0','1','0','0'],
  ['1','0','1','1','1'],
  ['1','1','1','1','1'],
  ['1','0','0','1','0']
]
Output: 6 =>[1 1 1
			 1 1 1]
 */
public class MaximalRectangleArea
{
	public static int maximalRectangle(char[][] matrix)
	{
        if(matrix.length == 0)
        	return 0;
        // for each cell with value=1, we look upward (north), the number of continuous '1' is the height of cell
        int[] heights = new int[matrix[0].length];
        int maxArea=-1;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=i; j<matrix[0].length; j++)
            {
                if(matrix[i][j]=='0')
                    heights[j] = 0;
                else 
                    heights[j] ++;
            }            
            int area = getMaxAreaHistogram(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
	
	//Method of Largest Rectangular of Histogram
	public static int getMaxAreaHistogram(int[] heights)
	{
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++)
        {
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()])
                s.push(i);
            else
            {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args)
	{
		char matrix[][] = {{'1','0','1','0','0'},
						   {'1','0','1','1','1'},
						   {'1','1','1','1','1'},
						   {'1','0','0','1','0'}};
		
		System.out.println(maximalRectangle(matrix));
	}
}
