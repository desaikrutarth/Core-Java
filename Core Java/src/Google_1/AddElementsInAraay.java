package Google_1;

import java.util.ArrayList;
import java.util.List;
/*
 * > Given an integer:N and an array int arr[], you have to add some 
For example: 
N=6, arr = [1, 3] 

1 is already in arr. 

add 2 to the arr. 

3 is already in arr 

4 = 1 + 3 

5 = 2 + 3 

6 = 1 + 2 + 3 

So we return 1 since we only need to add one element which is 2. 
 */
public class AddElementsInAraay 
{
	static int NumbersToAdd(int[] arr, int n)
	{
		int count = 0;
	    int sum = 0;
	    int index = 0;	    
	    
	    for(int i = 1; i < n ; i++)
	    {
	        if (index < arr.length && i == arr[index])
	        {
	            sum += arr[index];
	            index++;
	        }
	        else if (sum < i)
	        {
	            sum += i;
	            count++;
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,3};
		int n = 6;
		System.out.println(NumbersToAdd(arr, n));
	}
}
