package Backtracking;
/*
 * 		 a-----b
 * 		 |\	  /|\
 * 		 |  c  | e	
 * 		 |/	  \|/	
 * 		 d-----f
 */
public class HamiltonianCycle
{
	private int numOfVertexes;
	private int[] hamiltonianPath;
	private int[][] adjacencyMatrix;
	
	public HamiltonianCycle(int[][] adjacencyMatrix)
	{
		this.adjacencyMatrix = adjacencyMatrix;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
		this.numOfVertexes = adjacencyMatrix.length;
		
		this.hamiltonianPath[0] = 0;
	}

	public void solve()
	{
		if(findSolution(1))
			showHamiltonianPath();
		else
			System.out.println("No Solutions..");
	}

	private boolean findSolution(int position) 
	{
		if(position == numOfVertexes)
		{
			if(adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]] == 1)	//first vertex is equal to last vertex
				return true;
			else
				return false;
		}
		
		for(int vertexIndex = 1; vertexIndex < numOfVertexes; vertexIndex++)
		{
			if(isValidPosition(vertexIndex, position))
			{
				hamiltonianPath[position] = vertexIndex;
				if(findSolution(position+1))
					return true;
				
				//BACKTRACK
			}
		}
		return false;
	}

	private boolean isValidPosition(int vertexIndex, int position) 
	{
		//first criteria: Whether two nodes are connected?
		if(adjacencyMatrix[hamiltonianPath[position-1]][vertexIndex] == 0)
			return false;
		
		//second criteria: Whether we have visited it or not
		for(int i=0; i<position; i++)
		{
			if(hamiltonianPath[i] == vertexIndex)
				return false;
		}
		
		return true;
	}
	
	private void showHamiltonianPath() 
	{
		System.out.print("hamiltonion cycle: ");
		for(int i=0; i<hamiltonianPath.length; i++)
			System.out.print(hamiltonianPath[i]+" ");
		
		System.out.print(hamiltonianPath[0]);
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{0,1,1,1,0,0},
						  {1,0,1,0,1,0},
						  {1,1,1,1,0,1},
						  {1,0,1,0,0,1},
						  {0,1,0,0,0,1},
						  {0,1,1,1,1,1}};
		
		HamiltonianCycle cycle = new HamiltonianCycle(matrix);
		cycle.solve();
	}
}
