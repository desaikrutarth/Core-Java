package Google_1;

import java.util.Arrays;

/*
 * Given an array of length N and an integer K, sort the array as much as possible such that,
 * no element travels more than k positions to its left - an element however can travel as much as it likes to its right.
 */
public class SortArrayKPosition 
{

    public static void sort(int [] arr, int k)
    {

    	int temp;
        for(int i=0; i <k; i++)
        {
            for(int j=i+1; j < arr.length-i; j++)
            {
                if(arr[j-1] > arr[j])
                {
                    temp=arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println((i+1)+"th iteration result: "+Arrays.toString(arr));
        }
    }
    
    public static void main(String [] args) 
	{

        int [] arr = {20,4,3,2,1,7,8,0};

        System.out.println("Original Array: "+Arrays.toString(arr));

        sort(arr, 2);


    }

}
