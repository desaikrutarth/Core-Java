package Google_2;
/*
 * To a binary array, if you want to move 1 to the array side, 0 to the other side,
 * Can only swap two adjacent elements each time, ask the least number of swap Why?
 * For example,
 * the number of min swaps for [0, 1, 1, 0, 0] is 2 (01100 -> 10100 -> 11000)
 */

public class SwapMinimumCount 
{
	static int swapCount(int[] arr)
	{
		   int count=0;
		   int left = 0;

		   for(int i = left; i < arr.length; i++)
		   {
		      if(arr[i] == 1)
		      {
		          count += (i - left);
		          left++; 
		      }
		   }
		   return count;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {0, 1, 0, 1, 0};
		System.out.println(swapCount(arr));
	}
}
