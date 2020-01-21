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
	public static void findTempArray(int arr[])
	{
		String[] result = new String[arr.length];
		int index=0;
		
		int j=0;
		int i=1;
		
		while(i < arr.length)
		{
			if(arr[i] > arr[j])
			{
				result[index++] = String.valueOf(i-j);
				j++;
				i = j+1;
			}
			else
				i++;
		}
		
		while(index < result.length)
			result[index++] = "nothing";
		
		System.out.println(Arrays.toString(result));
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
    	int[] arr = {73, 74, 75, 71, 70, 76, 72};
    	findTempArray(arr);
    }
}
