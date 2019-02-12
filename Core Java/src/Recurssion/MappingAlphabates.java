package Recurssion;
import java.util.*;
import java.util.Map.Entry;

/* You are given a mapping like a -> 1, b-> 2… z-> 26. 
 * You have to print all possible combinations of a given number using the above information.
eg : input : 121 output : aba,la,au
*/
public class MappingAlphabates 
{
    static int decoding(String s, String perm) 
    {
        if (s.isEmpty()) 
        {
            System.out.println(perm);
            return 1;
        }
        int c = 0;
        
        String substring = s.substring(1);
        char code = code(Integer.parseInt(s.substring(0, 1)));
        c += decoding(substring, perm + code);
        
        if (s.length() > 1)
        {
        	substring = s.substring(2);
        	code = code(Integer.parseInt(s.substring(0, 2)));
            c += decoding(substring, perm + code);
        }
        return c;
    }

    static char code(int num) 
    {
    	char alpha = (char) ('a' + num - 1);
    	return alpha;
    }
    
	public static void main(String[] args) 
	{
        String s = "1123";
        System.out.println(decoding(s, ""));
    }
}
