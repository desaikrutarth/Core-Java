package Google_3;

import java.util.Arrays;

/*
 * The array of integers in given . The array indicates nothing but the heights of the cylinders.
   The robotic arm has two ends-> left and right. 
The left end points to the left end of the cylinder array and right end searched for the cylinder with least height. 
ex: 
array = {4,5,6,7,1,2} 
left end => index 0 
right end =>index 0->n giving index 4 with min height 
Now the entire block is rotated by 180 degree. 
now the array = { 1, 7, 6, 5, 4, 2} 
now the left end moves forward. 
and right end will search from left index onwards till the end of the array 
so left index = 1 
right index => 1-> n giving index 5 as min. height 
again do the block rotate . 
Write the code for this particular algorithm. 
However, there is one condition 
1. If there are duplicates in the array then the final order of those duplicates should remain the same. 
ex. If the cylinder with height 4 is appearing at index 3 and 5 in the initial array then the cylinder at index 3 should always appear before the one at index 5 in the final array
 */
public class RotateArray
{    
	static int[] rotate (int[] arr, int n)
	{
	    int left = 0;
	    int right = left + n;		//Given height of cylinder
	    
	    while(right < arr.length)
	    {
	        int[] rotateArr = arr.clone();		// Copy an original array
	        int index=left;						// index is the start of cylinder
	        
	        for(int i=right; i>=left; i--)
	          rotateArr[index++] = arr[i];
	        
	        left++;
	        right++;
	        
	        arr = rotateArr;
	        System.out.println(Arrays.toString(arr));
	    }
	    return arr;
	}
	
   public static void main(String []args)
   {
       int[] arr = {4,5,6,7,1,2};
       
       for (int ass: rotate(arr, 4))
         System.out.print(ass+" ");
    }
}
