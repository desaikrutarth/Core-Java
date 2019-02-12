package programs;

/*
 * Given an array of integers of size N. Assume ‘0’ as invalid number and all other as valid number. 
 * Write a program that modifies the array in such a way that if just next valid number is same as current number, double its value and replace the next number with 0. 
 * After the modification, rearrange the array such that all 0’s are shifted to the end and the sequence of the valid number or new doubled number is maintained as in the original array.
 */
class Test
{
	void theArray(int[] arr)
	{
		int[] result = new int[arr.length];
	    int index = 0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] != 0)
			{
				if(i < arr.length-1 && arr[i] == arr[i+1] )
				{
					arr[i]=arr[i]*2;
					arr[i+1]=0;
				}
				result[index++] = arr[i];
			}
			
		}
			
		for(int i=0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}

public class EaseTheArray
{
	public static void main(String[] args)
	{
		Test t = new Test();
		int[] arr = {2,2,0,4,0,8};
		t.theArray(arr);
	}
}
