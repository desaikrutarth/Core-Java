package Google_1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
/* Given an array, arrange the elements such that the number formed by concatenating the elements is highest.
E.g.: input = [9, 93, 24, 6], 
the output should be: [9,93,6,24].
 This is because if you concatenate all the numbers, 
993624 is the highest number that can be formed.  */

public class MaximumNumber
{
	static void printLargest(ArrayList<String> arr)
	{     
        Collections.sort(arr, new Comparator<String>()
        {
        	// A comparison function which is used by sort() in printLargest()
        	@Override
        	public int compare(String X, String Y)
        	{
        		// first append Y at the end of X
        		String XY=X + Y;
         
        		// then append X at the end of Y
        		String YX=Y + X;
         
        		// Now see which of the two formed numbers is greater
        		return XY.compareTo(YX) > 0 ? -1:1;
        	}
        });
         
        for(String s : arr)
        	System.out.print(s);
  
    }
	
	public static void main(String[] args)
	{
		ArrayList<String> arr = new ArrayList<>(Arrays.asList("9","93","24","6"));
        printLargest(arr);

	}
}
