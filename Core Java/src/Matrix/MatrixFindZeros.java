package Matrix;

public class MatrixFindZeros 
{
	static int  count =0;
	static int findZero(int[][] matrix)
	{
		search(matrix,0,0);
		return count;
	}
	
	private static void search(int[][] matrix, int i, int j)
	{
		int rowIndex = matrix.length;
		int colIndex = matrix[0].length;
		
		if(i<0||i>=rowIndex||j<0||j>=colIndex)
			return;
		
		if(matrix[i][j] == 0)
			count++;
		
		if(i == rowIndex-1 && j == colIndex-1)
			return;
		
		search(matrix, i+1, j);
		search(matrix, i, j+1);
	}
	//Method 1: Time complexity(O(n))
//	  static int findZero(int[][] matrix)
//	  {
//		  int count = 0;
//		  for(int i=0; i<matrix.length; i++)
//		  {
//			  count += getcounts(matrix[i]);
//		  }
//		  
//		return count;
//	  }
//	  static int getcounts(int arr[])
//	  {
//		  int noOfZeros = 0;
//		  for(int i=0; i<arr.length; i++)
//		  {
//			  if(arr[i] == 0)
//				  noOfZeros++;
//		  }
//		  return noOfZeros;
//	  }
	  
	  
	//Method 2: Time complexity(O(log(n)))
/*	public static int findZeroCount(int[][] matrix)
	{
        if (matrix == null || matrix.length < 1) {
            return 0;
        }

        int sumZeros = 0;
        int indexOfLastZero = matrix[0].length;

        for (int i = 0; i < matrix.length; i++)
        {
            indexOfLastZero = findIndexOfLastZero(matrix[i], 0, indexOfLastZero);
            if (indexOfLastZero >= 0) {
                sumZeros += (indexOfLastZero + 1);
            }
        }

        return sumZeros;
    }


    private static int findIndexOfLastZero(int[] array, int left, int right)
    {
        int mid = 0;
        while (right - left > 1)
        {
            mid = (left + right) / 2;
            if (array[mid] == 0) 
                left = mid;
            else 
                right = mid;
            
        }


        if (array[right] == 0) 
            return right;
        else if (array[left] == 0) 
            return left;
        else 
            return -1;      
    }*/
    
  
  
	
	


	public static void main(String[] args)
	{
		int[][] data = new int[][]{
            						{0, 0, 1},
            						{0, 1, 1},
            						{1, 1, 1}
												};
	//   System.out.println(findZeroCount(data));
	   System.out.println(findZero(data));
	}
}
