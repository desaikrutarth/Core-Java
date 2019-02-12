package Recurssion;
/*
Starting from num = 0, add 2^i (where i can be any non-negative integer) to num until num == N.
Print all paths of how num turns from 0 to N. 
For example if N = 4, 
Paths printed are [0,1,2,3,4], [0,1,2,4], [0,1,3,4], [0,2,4], [0,2,3,4], [0,4]. 
[0,2,4] is made from 0 + 2^1 + 2^1. [0,1,3,4] from 0 + 2^0 + 2^1 + 2^0
 */
public class PathSeriesPrint
{
	public static void printCombi(String str, int curr, int max)
	{
	    if(curr>=max)
	      System.out.print(str+max+"\n");
	    else
	    {
	      if(curr+2<=max)
	        printCombi(str+curr+",",curr+2, max);
	      
	      if(curr+1<=max)
	        printCombi(str+curr+",",curr+1, max);
	    }
	}
	  
	  
	  public static void main(String[] args)
	  {
	    printCombi("0,",1, 4);
	    printCombi("0,",2, 4);
	  }
}
