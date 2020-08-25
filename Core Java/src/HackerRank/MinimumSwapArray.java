package HackerRank;

import java.util.Arrays;

public class MinimumSwapArray
{
	static int minimumSwaps(int[] arr)
	{
        int swap=0;
        for(int i=0; i<arr.length; i++)
        {
            if(i+1 != arr[i])
            {
                int index = i;
                while(arr[index] != i+1)
                {
                    index++;  
                }
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                swap++;
            }
        }
        return swap;
    }

	//method 2:
/*	 static int minimumSwaps(int[] arr)
	 {
	     int count = 0;
	     int [] sortArr = arr.clone();
	     Arrays.sort(sortArr);
	        
	     for (int i = 0; i < arr.length; i++)
	     {
	         if (arr[i] != sortArr[i])
	         {
	             count++;
	             for (int j = i + 1; j < arr.length; j++)
	             {
	                 if (sortArr[i] == arr[j])
	                 {
	                     int tmp = arr[j];
	                     arr[j] = arr[i];
	                     arr[i] = tmp;
	                     break;
	                 }
	             }
	         }
	     }
	     return count;
	}*/
	
	public static void main(String[] args)
	{
		int[] arr = {2,3,4,1,5};
		System.out.println(minimumSwaps(arr));
	}
}
