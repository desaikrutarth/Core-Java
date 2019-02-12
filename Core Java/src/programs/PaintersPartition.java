package programs;


public class PaintersPartition 
{
	static int getMax(int arr[], int n)
	{
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < n; i++) 
	        if (arr[i] > max)
	            max = arr[i]; 
	    return max;
	}
	  
	// return the sum of the elements in the array
	static int getSum(int arr[], int n)
	{
	    int total = 0;
	    for (int i = 0; i < n; i++)
	        total += arr[i];
	    return total;
	}
	  
	// find minimum required painters for given maxlen
	// which is the maximum length a painter can paint
	static int numberOfPainters(int arr[], int n, int maxLen)
	{
	    int total = 0, numPainters = 1;
	  
	    for (int i = 0; i < n; i++)
	    {
	        total += arr[i];
	  
	        if (total > maxLen)
	        {
	  
	            // for next count
	            total = arr[i];
	            numPainters++;
	        }
	    }
	  
	    return numPainters;
	}
	  
	static int partition(int arr[], int n, int k)
	{
	    int lo = getMax(arr, n);
	    int hi = getSum(arr, n);
	  
	    while (lo < hi) 
	    {
	        int mid = lo + (hi - lo) / 2;
	        int requiredPainters = numberOfPainters(arr, n, mid);
	  
	        // find better optimum in lower half
	        // here mid is included because we
	        // may not get anything better
	        if (requiredPainters <= k)
	            hi = mid;
	  
	        // find better optimum in upper half
	        // here mid is excluded because it gives 
	        // required Painters > k, which is invalid
	        else
	            lo = mid + 1;
	    }
	  
	    // required
	    return lo;
	}
	 
	// Driver code
	public static void main(String args[])
	{
	 int arr[] = {10, 10, 10, 10 };
	  
	    // Calculate size of array.
	    int n = arr.length;
	        int k = 3;
	 System.out.println(partition(arr, n, k));
	}
}
/*
 * We have to paint n boards of length {A1, A2, .. An}. 
 * There are k painters available and each takes 1 unit time to paint 1 unit of board. 
 * The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards, 
 * say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Examples:

Input : k = 2, A = {10, 10, 10, 10} 
Output : 20.
Here we can divide the boards into 2
equal sized partitions, so each painter 
gets 20 units of board and the total
time taken is 20. 

Input : k = 2, A = {10, 20, 30, 40} 
Output : 60.
Here we can divide first 3 boards for
one painter and the last board for 
second painter.
*/
