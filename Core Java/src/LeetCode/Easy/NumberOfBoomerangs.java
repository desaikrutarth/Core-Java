package LeetCode.Easy;

import java.util.HashMap;
/*
 Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

Input:
[[0,0],[1,0],[-1,0],[0,1],[0,-1]]

Output:
20

 */
public class NumberOfBoomerangs 
{
	public static int numberOfBoomerangs(int[][] points) 
	{
        int count = 0;
        for(int[] p: points)
        {
            HashMap<Double, Integer> maps = new HashMap<>();
            for(int[] pair: points)
            {
                double dist = (p[0] - pair[0]) * (p[0] - pair[0]) + (p[1] - pair[1]) * (p[1] - pair[1]);
                
                if(maps.containsKey(dist))
                {
                	int val = maps.get(dist);
                    count = count + 2*val;
                }
                maps.merge(dist, 1, Integer::sum);
            }
        }
        return count;
    }
	
	public static void main(String[] args) 
	{
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
	}
}
