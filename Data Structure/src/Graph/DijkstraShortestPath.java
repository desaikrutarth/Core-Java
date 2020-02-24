package Graph;

import java.util.Arrays;
/*
  Below is a graph for given matrix where vertex are 0 to 4 and their distance between 2 vertex are given.
  Find the minimum distance to reach from vertex 0 to 4.
  
  			5
  		 1------3
 	  4 /|     /|
	   / |   5/ |
	  0  |2  /  |4
  	   \ |  /   |
  	  8 \| /    |
  		 2------4
  			9
  			
Distance from 0 to 1 -> 4
Distance from 0 to 2 -> 8
Distance from 1 to 2 -> 2
Distance from 1 to 3 -> 5
Distance from 2 to 3 -> 5
Distance from 2 to 4 -> 9
Distance from 3 to 4 -> 4 
 */
public class DijkstraShortestPath 
{
	static int numOfVertex = 0;
	static int[] distance;
	
	static void dijkstra(int[][] adjacentMatrix)
	{
		numOfVertex = adjacentMatrix.length;
		distance = new int[numOfVertex];	
		boolean visited[] = new boolean[numOfVertex];
		
		Arrays.fill(distance, Integer.MAX_VALUE);		//Fill all distance to Infinity
		distance[0] = 0;								//Start with first node
		
		for(int i=0; i < numOfVertex-1; i++)
		{
			//Find Vertex with minimum distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			
			//Explore neighbours
			for(int j=0; j < numOfVertex; j++)
			{
				if(adjacentMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE)
				{
					int newDistance = distance[minVertex] + adjacentMatrix[minVertex][j];
					if(newDistance < distance[j])
					{
						distance[j] = newDistance;
					}
				}
			}		
		}
	}
	
	static int findMinVertex(int[] distance, boolean visited[])
	{
		int minVertex = -1;
		for(int i=0; i<distance.length; i++)
		{
			if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex]))
			{
				minVertex = i;
			}
		}
		return minVertex;
	}
	
	// Print distances from Vertex 0
	public static void printDistance()
	{
		for(int i=1; i<numOfVertex; i++)
		{
			System.out.println("Minimum distance of Vertex 0 to Vertex "+i+" = "+distance[i]);
		}
	}
	
	public static void main(String[] args)
	{
		int[][] adjMatrix = {
							 {0,4,8,0,0},
							 {0,0,2,5,0},
							 {0,0,0,5,9},
							 {0,0,0,0,4},
							 {0,0,0,0,0}
										};
		dijkstra(adjMatrix);
		printDistance();
	}
}

/*
  Below is a graph for given matrix where vertex are 0 to 4 and their distance between 2 vertex are given.
  
  			5
  		 1------3
 	  4 /|     /|
	   / |   5/ |
	  0  |2  /  |4
  	   \ |  /   |
  	  8 \| /    |
  		 2------4
  			9
  			
  	 0 to 1 -> 4
  	 0 to 2 -> 8
  	 1 to 2 -> 2
  	 1 to 3 -> 5
  	 2 to 3 -> 5
  	 2 to 4 -> 9
  	 3 to 4 -> 4 
 */
