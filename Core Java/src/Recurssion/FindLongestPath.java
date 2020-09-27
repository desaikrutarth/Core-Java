package Recurssion;
import java.util.ArrayList;
import java.util.List;
/*
 * Find the longest unique value path in a graph 
* Definition for undirected graph. 
* 		    0
         / / \ \
        6  4  5 1
        		 \
        		  3
        		  |
        		  2
        		  |
        		  7
* class UndirectedGraphNode
* { 
* 	int label; 
* 	List<UndirectedGraphNode> neighbors; 
* 	UndirectedGraphNode(int x)
*  	{ 
*  		label = x;
*   	neighbors = new ArrayList<UndirectedGraphNode>();
*   } 
* } 
*/

class UndirectedGraphNode
{ 
 	int label; 
 	List<UndirectedGraphNode> neighbors; 
   
 	public UndirectedGraphNode(int x)
 	{
 		label = x;
 		neighbors = new ArrayList<UndirectedGraphNode>(); 
 	} 
}

public class FindLongestPath
{
	public static int maxpath(UndirectedGraphNode graph)
	{
	    if(graph == null)
	      return 0;
	    
	    int max = 0;
	    if(graph.neighbors.size() > 0)
	    {
	    	for(UndirectedGraphNode node : graph.neighbors)
	    	{
	    		if(node != null)
    				max = Math.max(max, maxpath(node));
	    	}
	    }
	    return max+1;
	}
	
/*	public static int maxpath(UndirectedGraphNode graph, List<String> visitedList, String path, int len, int max)
	{
	    if(graph == null)
	      return max;
	    
	    List<UndirectedGraphNode> neighborsList = graph.neighbors;
	    if(neighborsList.size() > 0)
	    {
	    	for(UndirectedGraphNode node: neighborsList)
	    	{
	    		if(!visitedList.contains(path+node.label))
	    		{
	    			if(node != null)
	    				max = maxpath(node, visitedList, path+node.label, len+1, max);
	    		}
	    	}
	    }
	    else
	    {
	      	visitedList.add(path);
	    	max = Math.max(max, len);
	      	return max;
	    }
	   
	    return max;
	}
*/	
	public static void main(String[] args)
	{
	  	UndirectedGraphNode u0 = new UndirectedGraphNode(0);
	    UndirectedGraphNode u1 = new UndirectedGraphNode(1);
	    UndirectedGraphNode u2 = new UndirectedGraphNode(2);
	    UndirectedGraphNode u3 = new UndirectedGraphNode(3);
	    UndirectedGraphNode u4 = new UndirectedGraphNode(4);
	    UndirectedGraphNode u5 = new UndirectedGraphNode(5);
	    UndirectedGraphNode u6 = new UndirectedGraphNode(6);
	    UndirectedGraphNode u7 = new UndirectedGraphNode(7);
	    
	    u0.neighbors.add(u6);
	    u0.neighbors.add(u4);
	    u0.neighbors.add(u5);
	    u0.neighbors.add(u1);
	    
	    u1.neighbors.add(u3);
	    u3.neighbors.add(u2);
	    u2.neighbors.add(u7);
	    
//	    int max = Integer.MIN_VALUE;
//	    int n = maxpath(u0, new ArrayList<>(), "", 0, max);
	    int n = maxpath(u0);
	    System.out.println(n);
	}
}
