package Google_2;
/*
 * A sequence of strings, printed first by column, on a screen of width K, 
Requires the first column of the same column by column alignment, 
At least one character interval between columns and columns, 
Ask how many lines at least? 
such as: 
The string sequence is {"abc", "de", "fghij", "k", "lmno", "p"} 
The screen width is 10 
The answer is at least 3 lines 
	abc k 
	de lmno 
	fghij p
 */
public class FixStringWidthK 
{
	public static int minRows(String[] strings, int K) 
	{
	    int rows = 0;

	    while (rows < Integer.MAX_VALUE)
	    {
	        rows++;

	        if (testMinRows(strings, rows, K)) 
	        	return rows;
	    }

	    return -1;
	}

	private static boolean testMinRows(String[] strings, int rows, int K) 
	{
	    for (int i = 0; i < rows; i++)
	    {
	        int rowCharCount = 0;
	        int space = 0;

	        for (int j = i; j < strings.length; j = j + rows)
	        {
	            rowCharCount += space;
	            rowCharCount += strings[j].length();
	            space = 1;

	            if (rowCharCount > K)
	            	return false;
	        }
	    }

	    return true;
	}
	
    public static void main(String[] args)
    {
    	String[] s = {"abc", "de", "fghij", "k", "lmno", "p"};
    	int k =10;
    	System.out.println(minRows(s,k));
    }
}
