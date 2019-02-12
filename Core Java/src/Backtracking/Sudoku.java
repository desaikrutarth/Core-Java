package Backtracking;

public class Sudoku
{
	public static final int BOARD_SIZE = 9;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;
	public static final int BOX_SIZE = 3;
	
	public int[][] sudokuTable;
	
	public Sudoku(int[][] sudokuTable)
	{
		this.sudokuTable = sudokuTable;
	}
	
	public void solveProblem()
	{
		if(solve(0, 0))
			showResults();
		else
			System.out.println("No Solutions...");
	}

	private boolean solve(int rowIndex, int colIndex)
	{
		if(rowIndex == BOARD_SIZE && ++colIndex == BOARD_SIZE)
			return true;
		
		if(rowIndex == BOARD_SIZE)
			rowIndex = 0;							//Reset rowIndex for the next Column
		
		if(sudokuTable[rowIndex][colIndex] != 0)	// if there is a value in the cell
			return solve(rowIndex+1, colIndex);	
		
		for(int num = MIN_NUMBER; num <= MAX_NUMBER; num++)
		{
			if(isValid(rowIndex,colIndex,num))		//if number is valid
			{
				sudokuTable[rowIndex][colIndex] = num;
				
				if(solve(rowIndex+1, colIndex))
					return true;
				
				//BACKTRACK
				sudokuTable[rowIndex][colIndex] = 0;
			}
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex, int actualNumber)
	{
		// if given number is already in the row, then it is invalid
		for( int i=0; i<BOARD_SIZE; i++)
		{
			if(sudokuTable[i][colIndex] == actualNumber)
				return false;
		}
		
		// if given number is already in the column, then it is invalid
		for( int j=0; j<BOARD_SIZE; ++j)
		{
			if(sudokuTable[rowIndex][j] == actualNumber)
				return false;
		}
		
		// if given number is already in the box(3X3), then it is invalid
		int boxRowOffset = (rowIndex / 3) * BOX_SIZE;
		int boxColumnOffset = (colIndex / 3) * BOX_SIZE;
		
		for(int i=0; i<BOX_SIZE; i++)
		{
			for(int j=0; j<BOX_SIZE; j++)
			{
				if(actualNumber == sudokuTable[boxRowOffset + i][boxColumnOffset + j])
					return false;
			}
		}
		return true;
	}

	private void showResults()
	{
		for(int i=0; i<BOARD_SIZE; i++)
		{
			if(i % 3 == 0)
				System.out.println(" ");			//New line after every 3 Rows
			
			for(int j=0; j<BOARD_SIZE; j++)
			{
				if(j % 3 == 0)
					System.out.print(" ");			//Space after every 3 Columns
				System.out.print(sudokuTable[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args)
	{
		int sudokuTable[][] = {{3,0,6,5,0,8,4,0,0},
							   {5,2,0,0,0,0,0,0,0},
							   {0,8,7,0,0,0,0,3,1},
							   {0,0,3,0,1,0,0,8,0},
							   {9,0,0,8,6,3,0,0,5},
							   {0,5,0,0,9,0,6,0,0},
							   {1,3,0,0,0,0,2,5,0},
							   {0,0,0,0,0,0,0,7,4},
							   {0,0,5,2,0,6,3,0,0}};
		
		Sudoku sudoku = new Sudoku(sudokuTable);
		sudoku.solveProblem();
	}
}
