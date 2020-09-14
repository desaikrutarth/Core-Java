package LeetCode.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
Also, there is no garden that has more than 3 paths coming into or leaving it.
Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, 
they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.
The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

Example 1:
Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]

Example 2:
Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]

Example 3:
Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 */
public class FlowerPlantingWithNoAdjacentGraph 
{
	 public static int[] gardenNoAdj(int N, int[][] paths) 
	 {
		 Map<Integer, Set<Integer>> map = new HashMap<>();
	     for (int i = 1; i <= N; i++)
	      	map.put(i, new HashSet<>());

	     for (int[] edge: paths) 
	     {
	         map.get(edge[0]).add(edge[1]);
	         map.get(edge[1]).add(edge[0]);
	     }

	     int[] ans = new int[N];
	     for (int i = 1; i <= N; i++) 
	     {
	         Set<Integer> set = new HashSet<>();
	         for (int k = 1; k <= 4; k++)
	          	set.add(k);
	            
	         for (int index : map.get(i)) 
	         {
	             if (set.contains(ans[index - 1])) 
	              	set.remove(ans[index - 1]);
	         }
	         ans[i - 1] = set.iterator().next();
	     }
	        
	     return ans;
	 }
	 
	 public static void main(String[] args)
	 {
		 int[][] path = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
		 System.out.println(gardenNoAdj(4, path));
	 }
}
