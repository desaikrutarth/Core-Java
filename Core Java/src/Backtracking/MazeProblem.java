package Backtracking;

public class MazeProblem 
{
	private int[][] mazeTable;
	private int[][] solutionTable;
	private int mazeSize;
	
	public MazeProblem(int[][] mazeTable)
	{
		this.mazeTable = mazeTable;
		this.mazeSize = mazeTable.length;
		this.solutionTable = new int[mazeSize][mazeSize];
	}
	
	public void solve()
	{
		if(solveMaze(0, 0))
			showResults();
		else
			System.out.println("No Solutions...");
	}

	private boolean solveMaze(int i, int j)
	{
		if(isFinished(i,j))
			return true;
		
		if(isValid(i,j))
		{
			solutionTable[i][j] = 1;
			
			if(solveMaze(i, j+1))		// Going right
				return true;
			
			if(solveMaze(i+1, j))		// Going down
				return true;
			
			//Backtrack
			solutionTable[i][j] = 0;
		}
		return false;
	}

	private boolean isValid(int i, int j)
	{
		if(i<0 || i>=mazeSize || j<0 || j>=mazeSize)
			return false;
		
		if(mazeTable[i][j] != 1)		// it is obstacle 
			return false;
		
		return true;
	}

	private boolean isFinished(int i, int j)
	{
		if(i == mazeSize-1 && j == mazeSize-1)		//It reaches to an Exit
		{
			solutionTable[i][j] = 1;
			return true;
		}
		return false;
	}
	
	private void showResults()
	{
		for(int i=0; i<mazeSize; i++)
		{
			for(int j=0; j<mazeSize; j++)
			{
				if(solutionTable[i][j] == 1)
					System.out.print(" S ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		int mazeTable[][] = {{1,1,1},
							 {0,1,0},
							 {0,1,1}};		// 0 -> Obstacle, 1 -> Valid Path
		
		MazeProblem maze = new MazeProblem(mazeTable);
		maze.solve();
	}
}
