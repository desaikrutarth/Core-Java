package HackerRank;

public class LongSum
{
	 static long aVeryBigSum(long[] arr)
	  {
	        Long sum = 0L;
	        for(int i=0; i<arr.length; i++)
	        {
	            sum = Long.sum(sum, arr[i]);
	        }
	     //   long result = Long.parseLong(sum);
	        return sum;
	   }
	 
	 public static void main(String[] args)
	 {
		 long[] arr = {1000000001,1000000002,1000000003,1000000004,1000000005};
		 System.out.println(aVeryBigSum(arr));
	 }
}
