package Google_2;

import java.util.HashMap;
import java.util.TreeMap;

/*
 * given a string p, called order, such as abc, means a in front of b, and so on
given a second string s, to determine whether it is follow the order of p, return boolean, 
example:
	If aaqqqbqqc return true, 
	If cba is false 
	If aaxyc is false, the letters that have not been seen in the order are skipped
 */
public class CheckOrderStrings 
{
	public static boolean isSubsequence(String order, String str)
	{
        int j=0;
		
        for(int i=0; i<str.length(); i++)
        {
            if(order.charAt(j) == str.charAt(i))
            	j++;
            
            if(j == order.length())
            	return true;
        }
		
        return false;
    }
	
	public static void main(String[] args)
	{
		String s = "abc";
		String p = "aaxyc";
		System.out.println(isSubsequence(s, p));
	}
}
