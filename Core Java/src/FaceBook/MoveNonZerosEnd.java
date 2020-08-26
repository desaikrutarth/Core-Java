package FaceBook;

import java.util.Arrays;
/*
Given an array of integers, design an algorithm that moves all non-zero integers to the end of the array.]
Minimize the number of writes or swaps.
Input : [-9,5,-1,3,-4,-5,7,8]
Output: [5,3,7,8,-9,-1,-4,-5]
 */
public class MoveNonZerosEnd
{
	public static Integer[] shortestSubstring(Integer[] arr)
	{
	    Arrays.sort(arr, (a,b) -> {
	    	if(a < 0)
	    		return 1;
	        
	    	if(b < 0)
	    		return -1;
	        
	    	return a;
	    });
	    return arr;
	}
	
	public static void main(String[] args)
	{
		Integer[] arr = {-9,5,-1,3,-4,-5,7,8};
		System.out.println(Arrays.toString(shortestSubstring(arr)));
	}
}
