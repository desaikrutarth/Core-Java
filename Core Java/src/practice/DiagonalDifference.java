package practice;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference
{
	 	public static int diagonalDifference(List<List<Integer>> arr)
	    {
	        int rows = arr.size();
	        int cols = arr.get(0).size();
	        int[][] matrix = new int[rows][cols];

	        for(int i=0; i<rows; i++)
	        {
	            for(int j=0; j<cols; j++)
	            {
	                matrix[i][j] = arr.get(i).get(j);
	            }
	        }

	        int diagonalSumLeft = 0;
	        for(int i=0,j=0; i<rows && j<cols; i++, j++)
	            diagonalSumLeft += matrix[i][j];
	        
	        int diagonalSumRight = 0;
	        for(int i=0, j=cols-1; i<rows && j>=0; i++, j--)
	            diagonalSumRight += matrix[i][j];
	        
	        return Math.abs(diagonalSumLeft - diagonalSumRight);
	    }
	 	
	 	public static void main(String[] args)
	 	{
	 		List<List<Integer>> arr = new ArrayList<List<Integer>>();
	 		
	 		int count=0;
	 		for(int i=0; i<3; i++)
	 		{
	 			List<Integer> list = new ArrayList<Integer>();	
	 			for(int j=0; j<3; j++)
	 			{
	 				list.add(++count);
	 			}
	 			arr.add(list);
	 		}
	 		System.out.println(arr);
	 		System.out.println(diagonalDifference(arr));
		}

}
