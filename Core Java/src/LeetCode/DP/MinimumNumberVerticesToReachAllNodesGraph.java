package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [from-i, to-i] represents
a directed edge from node from-i to node to-i.
Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
Notice that you can return the vertices in any order.

Example 1:

1
^
|
0 ---> 2 
      ^	\ 
	 /   \	
3-->4	  v
		   5
		   
Vertex 0 is connected to 1 and 2
Vertex 2 is connected to 5
Vertex 3 is connected to 4
Vertex 4 is connected to 2

Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
Output: [0,3]
Explanation: It's not possible to reach all the nodes from a single vertex. From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5].
So we output [0,3].

Example 2:

	  4
	  ^	\
	  |	 \
0 --> 1 <--2
	  ^
	  |
	  3

Vertex 0 is connected to 1
Vertex 1 is connected to 4
Vertex 2 is connected to 1 and 4
Vertex 3 is connected to 1

Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
Output: [0,2,3]
Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other node, so we must include them.
Also any of these vertices can reach nodes 1 and 4.
 */
public class MinimumNumberVerticesToReachAllNodesGraph 
{
	public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges)
	{
        Set<Integer> kids = new HashSet<>();
        for (List<Integer> e : edges)
        {
            kids.add(e.get(1));
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i)
        {
            if (!kids.contains(i)) 
                ans.add(i);
        }
        return ans; 
    }
	
	public static void main(String[] args)
	{
		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		edges.add(new ArrayList<>(Arrays.asList(0,1)));
		edges.add(new ArrayList<>(Arrays.asList(0,2)));
		edges.add(new ArrayList<>(Arrays.asList(2,5)));
		edges.add(new ArrayList<>(Arrays.asList(3,4)));
		edges.add(new ArrayList<>(Arrays.asList(4,2)));
		
		System.out.println(findSmallestSetOfVertices(6, edges));
	}
}
