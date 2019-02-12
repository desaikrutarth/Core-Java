package programs;

import java.util.Arrays;

// Given unsorted array and a number K. Find 2 numbers such that sum is K.

public class ArraySumNumbers
{
	// Method 1: O(n)
	public void SumArray(int[] arr, int sum)
	{		
		int i=0;
		int j=i+1;
		
		while(i < arr.length && j < arr.length)
		{
			if(arr[i] + arr[j] == sum)
				System.out.println(arr[i]+" + "+arr[j]+ " = " +sum);
			
			if(j == arr.length-1)
			{
				i++;
				j=i+1;
			}
			else
				j++;
		}
	}
	
	public static boolean checkPairs(int[] arr, int sum)
	{
		int left = 0;
		int right = arr.length - 1;
		
		Arrays.sort(arr);
		while(left < right)
		{
			if(arr[left] + arr[right] == sum)
				return true;
			else if(arr[left] + arr[right] < sum)
				left++;
			else
				right--;
		}
		return false;
	}
	
	// METHOD 2 (Use Hash Map): O(n) 
	private static final int MAX = 100000; // Max size of Hashmap
	public void printpairs(int arr[],int sum)
    {		
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];

        for (int i=0; i<arr.length; i++)
        {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && binmap[temp])
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", "+temp+")");
            else
            	binmap[arr[i]] = true;
        }
    }
	
	public static void main(String[] args)
	{
		ArraySumNumbers obj = new ArraySumNumbers();
		int[] arr = {1, 4, 45, 6, 10, -8};
		int k = 2;
		System.out.println(checkPairs(arr, k));
		obj.SumArray(arr,k);
		//obj.printpairs(arr, k);
	}
}
