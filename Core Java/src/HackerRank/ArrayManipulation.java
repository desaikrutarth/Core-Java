package HackerRank;
import java.util.Arrays;
/*
Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive.
Once all operations have been performed, return the maximum value in your array.
For example, the length of your array of zeros n = 10. Your list of queries is as follows:
a b k
1 5 3
4 8 7
6 9 1
Add the values of k between the indices a and b inclusive:
index->	 1 2 3  4  5 6 7 8 9 10
		[0,0,0, 0, 0,0,0,0,0, 0]
		[3,3,3, 3, 3,0,0,0,0, 0]
		[3,3,3,10,10,7,7,7,0, 0]
		[3,3,3,10,10,8,8,8,1, 0]
Sample Input:

a b  k
1 2 100
2 5 100
3 4 100

Sample Output:
200

Explanation:

After the first update list will be 100 100 0 0 0.
After the second update list will be 100 200 100 100 100.
After the third update list will be 100 200 200 200 100.
The required answer will be 200.
 */
public class ArrayManipulation
{
	static long arrayManipulation(int n, int[][] queries)
    {
        long[] arr = new long[n+1];

        for(int i=0; i<queries.length; i++)
        {
            int[] row = queries[i];
            int a = row[0];
            int b = row[1];
            int k = row[2];

            arr[a-1] += k;
            arr[b] -= k;
            System.out.println(Arrays.toString(arr));
        }
        
        long sum = 0;
        long maxval = Long.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
        	sum += arr[i];
            maxval = Math.max(maxval, sum);
        }
        return maxval;
    }
	
/*	static long arrayManipulation(int n, int[][] queries)
    {
        long[] arr = new long[n];
        long maxval = Long.MIN_VALUE;

        for(int i=0; i<queries.length; i++)
        {
            int[] row = queries[i];
            int start = row[0];
            int end = row[1];
            int k = row[2];

            for(int j=start-1; j<end; j++)
            {
                arr[j] += k;
                maxval = Math.max(maxval, arr[j]);
            }
            System.out.println(Arrays.toString(arr));
        }
        return maxval;
    }*/
	
	public static void main(String[] args)
	{
		int[][] queries = {{1,2,100},
						   {2,5,100},
						   {3,4,100}};
		System.out.println("Maximum sum = "+arrayManipulation(5, queries));
	}

}
