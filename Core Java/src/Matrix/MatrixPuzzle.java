package Matrix;
/*
 DP Problem. Given the length and width of a matrix, get the number of paths from bottom-left to bottom right. 
You may only walk into those 3 directions ➡ (right) ↗ (upper-right) ↘ (lower-right) at each point. 
Follow-up: optimize 2d DP to 1d DP of linear extra space. 
Follow-up: what if some cells are blocked 

 */

public class MatrixPuzzle 
{
	static int numberOfPaths = 0;
	public static int findNumberOfPaths(int length, int width)
	{
		int i = length-1;	
		int j = 0;			//i and j are set to bottom left
		
		findNumberOfPathsHelper(length,width,i,j);
		
		return numberOfPaths;
	}
	
	public static void findNumberOfPathsHelper(int rows, int cols, int i, int j)
	{
		if(i<0 || i>=rows || j<0 || j>=cols)
			return;
		
		if(i == rows-1 && j == cols-1)
		{
			numberOfPaths++;
			return;
		}
		
		findNumberOfPathsHelper(rows, cols, i, j+1);		//move to right
		findNumberOfPathsHelper(rows, cols, i-1, j+1);		//move to Upper-right
		findNumberOfPathsHelper(rows, cols, i+1, j+1);		//move to lower-right
	}
    
    public static void main(String[] args)
    {
    	System.out.println(findNumberOfPaths(3,3));
    }
}
