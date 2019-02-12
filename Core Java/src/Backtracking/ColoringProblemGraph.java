package Backtracking;

/*
 * 		 a-----b
 * 		 |\	  /|\
 * 		 |  c  | e	
 * 		 |/	  \|/	
 * 		 d-----f
 */
public class ColoringProblemGraph
{
	private int numOfVertex;
	private int numOfColors;
	private int[] colors;
	private int[][] adjacencyMatrix;
	
	public ColoringProblemGraph(int[][] adjacencyMatrix, int numOfColors)
	{
		this.numOfColors = numOfColors;
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVertex = adjacencyMatrix.length;
		this.colors = new int[numOfVertex];
	}
	
	public void solve()
	{
		if(solveProblem(0))
			showResults();
		else
			System.out.println("No solutions...");
	}

	private boolean solveProblem(int nodeIndex)
	{
		if(nodeIndex == numOfVertex)
			return true;
		
		for(int colorIndex=1; colorIndex <= numOfColors; colorIndex++)
		{
			if(isValidColor(nodeIndex,colorIndex))
			{
				colors[nodeIndex] = colorIndex;
				if(solveProblem(nodeIndex+1))
					return true;
				
				//BACKTRACK
			}
		}
		return false;
	}

	private boolean isValidColor(int nodeIndex, int colorIndex)
	{
		for(int i=0; i<numOfVertex; i++)
		{
			if(adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i])
				return false;
		}
		return true;
	}

	private void showResults() 
	{
		for(int i=0; i<numOfVertex; i++)
			System.out.println("Node "+(i+1)+" has color index: "+colors[i]);
	}
	
	public static void main(String[] args) 
	{
		int[][] matrix = {{0,1,1,1,0,0},
				  		  {1,0,1,0,1,0},
				  		  {1,1,1,1,0,1},
				  		  {1,0,1,0,0,1},
				  		  {0,1,0,0,0,1},
				  		  {0,1,1,1,1,1}};
		
		int numOfColors = 4;
		
		ColoringProblemGraph color = new ColoringProblemGraph(matrix, numOfColors);
		color.solve();
	}
}
