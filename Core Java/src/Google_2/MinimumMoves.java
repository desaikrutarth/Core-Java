package Google_2;
/*
 * Given a string, at each time, you can move any one of the char to the front,
ask you to find the minimum such move to get the target string 
example 
source abc, target cba : 
abc -> bac -> cba 
return 2
 */
public class MinimumMoves 
{
	public static int countMoves(String str1, String str2)
	{
	    if (str1.length() != str2.length())
	    	return -1;
	    
	    int moves = 0;   
	    int j = str1.length() - 1;
	    
	    for (int i = str1.length() - 1; i >= 0; i--) 
	    {
	        if (str1.charAt(i) == str2.charAt(j))
	            j--;
	        else 
	            moves++;	        
	    }

	    return moves;
	}

	 public static void main(String args[]) 
	 {
		 String str1 = "abc";
		 String str2 = "cba";
		 System.out.println(countMoves(str1,str2));
	        
	 }
}
