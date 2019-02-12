package Google_2;
/*
 * Given two strings A and B, the task is to convert A to B if possible.
 * The only operation allowed is to put any character from A and insert it at front.
 * Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation.

Input:  A = "ABD", B = "BAD"
Output: 1
Explanation: Pick B and insert it at front.

Input:  A = "EACBD", B = "EABCD"
Output: 3
Explanation: Pick B and insert at front, EACBD => BEACD
             Pick A and insert at front, BEACD => ABECD
             Pick E and insert at front, ABECD => EABCD
 */
public class CountMinimumSwap 
{
	public static int minOps(String A, String B)
    {        
        if(A.length() != B.length())
            return -1;
         
        int i, j, count = 0;
        
        i = A.length() - 1;
        j = B.length() - 1;
 
        while(i >= 0)
        {
            // If there is a mismatch, then 
            // keep incrementing result 'res'
            // until B[j] is not found in A[0..i]
            if(A.charAt(i) != B.charAt(j))
            	count++;
            else
                j--;
            i--;         
        }
        return count;     
    }
	
	public static void main(String[] args) 
    {
        String A = "ate";
        String B = "eat"; 
         
        System.out.println("Minimum number of "
                    + "operations required is "
                                 + minOps(A, B));
    }
}
