package Google_1;
import java.util.Arrays;

import practice.Practice;

/*
 * There are some elements and a space in an array. sort and swap the elements so that space will move at the end of all elements.
 */
public class SwapAndSortGap 
{	  

	private static void sortGap(Integer[] arr) 
	{
		Arrays.sort(arr, (a,b) ->{
			if(a == -1)
				return 1;		// put a after b [b,a]
			else if(b == -1)
				return -1;		// put a before b [a,b]
			
			return a-b;			// else arrange in ascending order
		});
		System.out.println("Finally"+Arrays.toString(arr));
	}
	  public static void main(String[] args)
	  {
		  Integer[] arr = {-1,33,13,15,25,10};		//-1 represents gap
		  sortGap(arr);
	  }

	
}
