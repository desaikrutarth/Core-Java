package Google_3;

import java.util.Arrays;
import java.util.Stack;
/*
 * Given a list of daily temperatures, produce a list that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature. 
[73, 74, 75, 71, 70, 76, 72] -> [1, 1, 3, 2, 1, nothing, nothing]
 */
public class FindTemperature
{
	//Method 1: O(n)
	public static void findTempArray(int array[])
	{
		int left = 0;
		int right = left+1;
		int[] newArr = new int[array.length];
		int index = 0;
		newArr[newArr.length-1] = -1;
		
		while(right < array.length-1)
		{
			if(array[right] > array[left])
			{
				newArr[index++] = right - left;
				left++;
				right = left+1;
			}
			else
				right++;
			
			if(left == array.length-2)
			{
				if(array[right] > array[left])
					newArr[index] = right - left;
				else
					newArr[index] = -1;
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
	
	/* Method 2 : O(n^2)
	 public static void findTempArray(int array[])
	{		
		// last element is always 'nothing'
        int[] res = new int[array.length];
        res[array.length - 1] = -1;
        
        int j;
        for (int i = 0; i < array.length; i++) 
        {
            for (j = i+1; j < array.length - 1; j++)
            {
                if (array[i] < array[j]) 
                {
                    res[i] = j - i;
                    break;
                }
                
            }
            if (j == array.length - 1) {
                res[i] = -1;
            }
            
        }
        System.out.println(Arrays.toString(res));
	}*/
	
    public static void main(String[] args)
    {
    	int[] arr = {73, 74, 75, 71, 70, 76, 78};
    	findTempArray(arr);
    }
}
