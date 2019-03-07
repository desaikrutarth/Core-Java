package Recurssion;
public class LongestCommonSubsequence 
{
	 /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	  int lcs( char[] X, char[] Y, int m, int n )
	  {
	    if (m == 0 || n == 0)
	      return 0;
	    if (X[m-1] == Y[n-1])                   // Case 1: last character of both strings are same
	    {
	    	int result = lcs(X, Y, m-1, n-1);	// Move Diagonal 
	    	return 1 + result;
	    }	      
	    else								    // Case 2: last character of both strings are different
	    {
	    	int a = lcs(X, Y, m, n-1);
	    	int b = lcs(X, Y, m-1, n);
	    	return max(a,b);
	    }
	      
	  }
	 
	  /* Utility function to get max of 2 integers */
	  int max(int a, int b)
	  {
		  if(a > b)
			  return a;
		  else
			  return b;
	  }
	 
	  public static void main(String[] args)
	  {
	    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
	    String s1 = "krutarth";
	    String s2 = "hitarth";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +
	                                  lcs.lcs( X, Y, m, n ) );
	  }
	 
}
