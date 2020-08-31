package LeetCode.Medium;

public class BinarySearchMatrix
{
	public static boolean searchMatrix(int[][] matrix, int target)
	{
		if(matrix.length == 0)
			return false;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int start = 0;
		int end = rows * cols - 1;
		
		while(start <= end)
		{
			int mid = (start + end) / 2;
			int mid_value = matrix[mid/cols][mid%cols];
			
			if( mid_value == target)
				return true;
			else if(mid_value < target)
				start = mid+1;
			else
				end = mid-1;
		}		
		return false;
	}
	
	//Method 2:
/*	 public static boolean searchMatrix(int[][] matrix, int target)
	 {
		 if(matrix.length == 0)
			 return false;
	     int i = 0, j = matrix[0].length - 1;
	     while (i < matrix.length && j >= 0)
	     {
	    	 if (matrix[i][j] == target)
                 return true;
             else if (matrix[i][j] > target)
                 j--;
             else
                 i++;
	     }
            
         return false;
	 }
*/	
	public static void main(String[] args)
	{
		int[][] arr = {{1,  3,  5,  7},
			   	   	   {10, 11, 16, 20},
			   	   	   {23, 30, 34, 50}};

		System.out.println(searchMatrix(arr, 3));
	}
}
