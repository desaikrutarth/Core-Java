package Google_2;
/*
 Question:
 Given a sorted integer array, return sum of array so that each element is unique by adding some numbers to duplicate elements so that sum of unique elements is minimum. 
I.e., if all elements in the array are unique, return the sum. 
If some elements are duplicates, then increment them to make sure all elements are unique so that the sum of these unique elements is minimum. 

Some examples: 

input1[] = { 2, 3, 4, 5 } => return 14 = 2+3+4+5 (all elements are unique, so just add them up) 
input2[] = { 1, 2, 2 } => return 6 = 1+2+3 (index 2 is duplicate, so increment it) 
input3[] = { 2, 2, 4, 5 } => return 14 = 2+3+4+5 (index 1 is duplicate, so increment it)
 */
public class SumOfUniqueElements
{
	static int uniqueSum(int[] arr)
	{
		int sum = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] - arr[i-1] == 0)
				arr[i]++;
				
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {2, 2, 4, 5, 5};
		System.out.println(uniqueSum(arr));
	}
}
