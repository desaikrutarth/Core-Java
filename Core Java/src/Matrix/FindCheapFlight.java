package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
give a list of cities a to city b the price of air tickets for example 
a b 100 $ 
b c 200 $ 
e f 200 $ 
... 
Now let you from city x to city y, you cannot transfer more than twice between the two city,
find the cheap flight from x to y, follow up print out the flight
 */
/**
		    200
  		 1------2
 	 100/ \100 /
	   /   \  /50
	  0------3
        400
        	
0->1 100
1->2 200
2->3 50
0->3 400
1->3 100

  0    1   2     3
0 0   100  0    400
1 100  0   200  100 
2 0   200  0    50 
3 400 100  50   0 

*/
public class FindCheapFlight 
{
	static int dijkstra(int[][] adjacentMatrix)
	{
		int numOfVertex = adjacentMatrix.length;
		int[] distance = new int[numOfVertex];	
		boolean visited[] = new boolean[numOfVertex];
		
		Arrays.fill(distance, Integer.MAX_VALUE);		//Fill all distance to Infinity
		distance[0] = 0;								//Start with first node
		
		for(int i=0; i < numOfVertex-1; i++)
		{
			visited[i] = true;
			
			//Explore neighbours
			for(int j=0; j < numOfVertex; j++)
			{		//If two vertex are connected  &&  Not visited  &&  Distance between two vertex is not infinite
				if(adjacentMatrix[i][j] != 0 && !visited[j] && distance[i] != Integer.MAX_VALUE)
				{
					int newDistance = distance[i] + adjacentMatrix[i][j];
					distance[j] = Math.min(distance[j], newDistance);	  //Calculated minimum distance between two Vertex
				}
			}
		}
		
		// Printing minimum distance from City A to each Cities
		for(int i=1; i<numOfVertex; i++)
		{
			System.out.println("Minimum distance of Vertex 0 to Vertex "+i+" = "+distance[i]);
		}
		System.out.println();
		
		return distance[numOfVertex-1];	
	}
		
	/*public static int mincost(int[][] nodes)
	{
		List<Integer> visited = new ArrayList<Integer>();
		int org = 0;
	    int dest = 3;
	    visited.add(org);
	    
	    return mincostHelper(nodes, org, dest, 0, 0, visited);
	}
	
	static int mincost =  Integer.MAX_VALUE;
	public static int mincostHelper(int[][] nodes, int org, int dest, int hops, int cost, List<Integer> visited)
	{
	    if(org == dest)
	    {
	      if(hops < 4)
	      {
	      	mincost = Math.min(mincost, cost);
	      }
	      return mincost;
	    }
	    if(hops > 3)
	      return mincost;
	    
	    int[] connections = nodes[org];
	    int n = connections.length;
	    
	    for(int i = 0; i < n; i++)
	    {
	      if(connections[i] != 0 && !visited.contains(i))
	      {
	        visited.add(i);
	      	mincost = mincostHelper(nodes, i, dest, hops+1, cost+connections[i], visited);
	        visited.remove(new Integer(i));
	      }
	    }
	    return mincost;
	  }
	  */
	  public static void main(String[] args)
	  {  
		    int[][] nodes = new int[][]{{0, 100, 0, 400},
		    							{100, 0, 200, 100},
		    							{0, 200, 0, 50},
		    							{400, 100, 50, 0}};
		    							
		   System.out.println("Minimum distance from City A to City D = "+dijkstra(nodes));
		  //System.out.println(mincost(nodes));
	  }
}
