package Matrix;

public class MatrixMaxShape
{
	  
	  public static int maxContagiousShape(char[][] fill){
	  	int n = fill.length;
	    int m = fill[0].length;
	    int[][] dp = new int[n][m];
	    
	    //for extreme left corner, max contagious size would be 1 if it is 'X'
	    if(fill[0][0] == 'X')
	      dp[0][0] = 1;
	    
	    //contagious shapes in 1st row
	    for(int i = 1; i < m; i++){
	      if(fill[0][i] == 'X')
	        dp[0][i] = dp[0][i-1] + 1;
	      else
	    	dp[0][i] = dp[0][i-1];
	    }
	    
	    //contagious shapes in 1st column
	    for(int i = 1; i < n; i++){
	      if(fill[i][0] == 'X')
	        dp[i][0] = dp[i-1][0] + 1;
	      else
	    	dp[i][0] = dp[i-1][0];
	    }
	    
	    //fill up the remaining
	    for(int i = 1; i < n; i++){
	      int contX = 0;
	      for(int j = 1; j < m; j++){
	      
	        if(fill[i][j] == 'X')
	        	contX += 1;
	        else   
	       		contX = 0;
	      
	        
	        if(fill[i][j] == '.'){
	        	if(fill[i-1][j] == 'X' && fill[i][j-1] == 'X')
	             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) +1;
	              
	            if(fill[i-1][j] == 'X' && fill[i][j-1] == '.')
	              dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) +1;
	              
	            if(fill[i-1][j] == '.' && fill[i][j-1] == 'X')
	             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	              
	            if(fill[i-1][j] == '.' && fill[i][j-1] == '.')
	              dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	              
	        }else{
	       	 	if(fill[i-1][j] == 'X' && fill[i][j-1] == 'X')
	               dp[i][j] = Math.max(dp[i-1][j]+contX, dp[i][j-1] +1);
	               
	            if(fill[i-1][j] == 'X' && fill[i][j-1] == '.')
	              dp[i][j] = Math.max(dp[i-1][j]+1, dp[i][j-1] +2);
	              
	            if(fill[i-1][j] == '.' && fill[i][j-1] == 'X')
	              dp[i][j] = Math.max(dp[i-1][j]+contX, dp[i][j-1] +1);
	              
	            if(dp[i-1][j] == '.' && dp[i][j-1] == '.')
	              dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	        }
	      }
	    }
	    return dp[n-1][m-1];
	    
	  }
	  public static void main(String[] args)
	  {
	    char[][] fill = {
	      	{'.', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.', '.', '.' },
			{'.', '.', '.', 'X', '.', '.', 'X', 'X', '.', '.', 'X' },
			{'.', '.', '.', 'X', 'X', 'X', 'X', '.', '.', '.', '.' },
			{'.', '.', 'X', '.', '.', '.', '.', '.', 'X', '.', '.' },
			{'.', '.', 'X', 'X', 'X', '.', '.', 'X', 'X', '.', '.' },
			{'.', '.', '.', '.', '.', 'X', 'X', '.', '.', '.', '.' }
	    };
	    
	    System.out.println(maxContagiousShape(fill));
	  }
}
