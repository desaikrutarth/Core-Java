package Google_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/* Given an array, arrange the elements such that the number formed by concatenating the elements is highest.
E.g.: input = [9, 93, 24, 6], 
the output should be: [9,93,6,24].
 This is because if you concatenate all the numbers, 
993624 is the highest number that can be formed.  */

public class MaximumNumber
{
	static void printLargest(ArrayList<String> list)
	{     
        Collections.sort(list, new Comparator<String>()
        {
        	@Override
        	public int compare(String X, String Y)	// A comparison function which is used by sort() in printLargest()
        	{
        		String XY = X + Y;		// first append Y at the end of X
        		String YX = Y + X;		// then append X at the end of Y
         
        		if(XY.compareTo(YX) > 0)	// if XY > YX
        			return -1;				// returns negative means String X comes before String Y [X,Y]
        		
        		return 1;			// return positive means String Y comes before String X [Y,X]
        	}
        });
         
        for(String s : list)
        	System.out.print(s);
    }
	
	public static void main(String[] args)
	{
		ArrayList<String> arr = new ArrayList<>(Arrays.asList("9","93","24","6"));
        printLargest(arr);

	}
}
