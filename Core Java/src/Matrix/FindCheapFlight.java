package Matrix;

import java.util.ArrayList;
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
	static int mincost =  Integer.MAX_VALUE;
	public static int mincost(int[][] nodes, int org, int dest, int hops, int cost, List<Integer> visited)
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
	      	mincost = mincost(nodes, i, dest, hops+1, cost+connections[i], visited);
	        visited.remove(new Integer(i));
	      }
	    }
	    return mincost;
	  }
	  
	  public static void main(String[] args)
	  {  
		    int[][] nodes = new int[][]{{0, 100, 0, 400},
		    							{100, 0, 200, 100},
		    							{0, 200, 0, 50},
		    							{400, 100, 50, 0}};
		    int org = 0;
		    int dest = 3;
		    
		    List<Integer> visited = new ArrayList<Integer>();
		    visited.add(org);
		    int n = mincost(nodes, org, dest, 0, 0, visited);
		  	System.out.println(n);
		  }
}
