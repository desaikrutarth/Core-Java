package Graph;

import java.util.Arrays;

public class DijkstraShortestPath 
{
	static void dijkstra(int[][] adjacentMatrix)
	{
		int v = adjacentMatrix.length;
		boolean visited[] = new boolean[v];
		int[] distance = new int[v];	
		
		Arrays.fill(distance, Integer.MAX_VALUE);		//Fill all distance to Infinity
		distance[0] = 0;								//Start with first node
		
		for(int i=0; i < v-1; i++)
		{
			//Find Vertex with minimum distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			
			//Explore neighbours
			for(int j=0; j < v; j++)
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
		
		for(int i=0; i<v; i++)
			System.out.println(i + " "+ distance[i]);
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
	}
}
