package Google_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 Question:
 Given a sorted integer array, return sum of array so that each element is unique by adding some numbers to duplicate elements so that sum of unique elements is minimum. 
I.e., if all elements in the array are unique, return the sum. 
If some elements are duplicates, then increment them to make sure all elements are unique so that the sum of these unique elements is minimum. 

Some examples: 

input1[] = { 2, 3, 4, 5 } => return 14 = 2+3+4+5 (all elements are unique, so just add them up) 
input2[] = { 1, 2, 2 } => return 6 = 1+2+3 (index 2 is duplicate, so increment it) 
input3[] = { 2, 2, 4, 5 } => return 14 = 2+3+4+5 (index 1 is duplicate, so increment it)
input4[] = {2, 2, 3, 4, 5, 5} => return 27 = 2+6+3+4+5+7
input5[] = {2, 2, 2, 2, 2} => return 20 = 2+3+4+5+6
 */
public class SumOfUniqueElements
{
	// method 1: O(n)
	static int uniqueSum(Integer[] arr)
	{
	    int sum = arr[0];
	    int prev = arr[0];

	    for( int i = 1; i < arr.length; i++)
	    {
	        int curr = arr[i];

	        if( prev >= curr ) {
	            curr = prev+1;
	        }
	        sum += curr;
	        prev = curr;
	    }

	    return sum;
	}
	// method 2: O(n)^2
	/*static int uniqueSum(Integer[] arr)
	{
	    List<Integer> list = new ArrayList<>();
	    list.add(arr[0]);
	    
	    for(int i=1; i<arr.length; i++)
	    {
	    	while(list.contains(arr[i]))
	    		arr[i]++;
	    	
	    	list.add(arr[i]);
	    }
	    
	    int result=0;
	    for(int i : list)
	    	result += i;
	    
	    return result;
	}*/
	
	public static void main(String[] args)
	{
		Integer[] arr = {2, 2, 2, 2, 2};
		System.out.println(uniqueSum(arr));
	}
}
