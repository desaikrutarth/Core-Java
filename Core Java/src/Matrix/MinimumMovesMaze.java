package Matrix;
/*
 * Given a matrix of maze which Obstacles. There are multiple ways to reach to Exit. 0 represents an Obstacle and 1 represents valid path.
 * You can go Horizontal, Vertical and Diagonal ways. Find minimum Moves to reach to exit.
 * [1  1  1
     \      
    0  1  0
		\   
    0  1  1]   Minimum moves = 2 
 */
public class MinimumMovesMaze
{
	static int minMoves = Integer.MAX_VALUE;	
	public static int mazeSolve(int[][] mazeTable) 
	{		
		mazeSolveHelper(mazeTable,0,0,0);
		return minMoves;
	}

	private static void mazeSolveHelper(int[][] mazeTable, int i, int j, int move)
	{
		int rows = mazeTable.length;
		int cols = mazeTable[0].length;
		
		if(i<0 || i>=rows || j<0 || j>=cols)
			return;
		
		if(mazeTable[i][j] != 1)	// If it is obstacle
			return;
		
		if(i == rows-1 && j == cols-1)
		{
			minMoves = Math.min(minMoves, move);
			System.out.println(move);
			return;
		}
		
		move++;
		mazeSolveHelper(mazeTable, i, j+1, move);
		mazeSolveHelper(mazeTable, i+1, j+1, move);
		mazeSolveHelper(mazeTable, i+1, j, move);
	}

	public static void main(String[] args)
	{
		int mazeTable[][] = {{1,1,1},
							 {0,1,0},
							 {0,1,1}};		// 0 -> Obstacle, 1 -> Valid Path
		
		System.out.println("Minimum Moves = "+mazeSolve(mazeTable));
	}
}
