package Backtracking;

public class N_QueensProblem
{
	public int[][] chessTable;
	public int numOfQueens;
	
	public N_QueensProblem(int numOfQueens)
	{
		this.chessTable = new int[numOfQueens][numOfQueens];
		this.numOfQueens = numOfQueens;
	}
	
	public void solve()
	{
		if(setQueens(0))
			printQueens();
		else
			System.out.println("There is no solutions..");
	}

	private boolean setQueens(int colIndex)
	{
		if(colIndex == chessTable.length)
			return true;
		
		for(int rowIndex=0; rowIndex < chessTable.length; rowIndex++)
		{
			if(isValidPlace(rowIndex, colIndex))
			{
				chessTable[rowIndex][colIndex] = 1;
				
				if(setQueens(colIndex+1))
					return true;
				
				//BACKTRACKING
				chessTable[rowIndex][colIndex] = 0;
			}
		}
		return false;
	}

	private boolean isValidPlace(int rowIndex, int colIndex)
	{
		//Checking in Horizontal(row) way
		for(int i=0; i<colIndex; i++)
		{
			if(chessTable[rowIndex][i] == 1)
				return false;
		}
		
		//Checking Diagonal from bottom right to top left
		for(int i=rowIndex, j=colIndex; i>=0 && j>=0; i--,j--)
		{
			if(chessTable[i][j] == 1)
				return false;
		}
		
		//Checking Diagonal from top right to bottom left
		for(int i=rowIndex, j=colIndex; i<chessTable.length && j>=0; i++,j--)
		{
			if(chessTable[i][j] == 1)
				return false;
		}
		return true;
	}

	private void printQueens() 
	{
		for(int i=0; i<chessTable.length; i++)
		{
			for(int j=0; j<chessTable.length; j++)
			{
				if(chessTable[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		N_QueensProblem queen = new N_QueensProblem(4);
		queen.solve();
	}
}
