package Matrix;

/*
 * The path with minimum cost is highlighted in the following figure. 
 *  [1--2  3
          \ 
     4	8  2
		   |
     1  5  3] 
 * The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).
 */
public class MinimumCostPath 
{
	int result=Integer.MAX_VALUE;
	public int minCost(int[][] cost)
	{
		dfs(cost, 0, 0, 0);
		return result;
	}

	private void dfs(int[][] cost, int i, int j, int sum)
	{		
		int row=cost.length, col=cost[0].length;
		if(i<0||i>=row||j<0||j>=col)
			return;
		
		sum += cost[i][j];
		if(i==row-1 && j==col-1)
		{
			result=Math.min(result, sum);
			return;
		}

		dfs(cost, i+1, j, sum);
		dfs(cost, i+1, j+1, sum);
		dfs(cost, i, j+1, sum);
	}

    /*private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = cost[0][0];
 
         Initialize first column of total cost(tc) array 
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
         Initialize first row of tc array 
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
         Construct rest of the tc array 
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1], 
                               tc[i-1][j],
                               tc[i][j-1]) + cost[i][j];
 
        return tc[m][n];
    }
    
	private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }*/
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
     //   System.out.println("minimum cost to reach (2,2) = " + minCost(cost,2,2));
        System.out.println("minimum cost to reach (2,2) = " + new MinimumCostPath().minCost(cost));
    }
}
