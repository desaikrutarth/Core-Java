package programs;

import java.io.IOException;
import java.util.*;

public class OddNumberInArray
{
	static int[] oddNumbers(int lb, int ub)
    {
		Scanner in = new Scanner(System.in);
		int j=0;
		int oddArray[] = new int[ub/2-1];
		for(int i=lb; i <= ub; i++)
		{
			if(i%2 != 0)
				oddArray[j++] = i;			
		}
		return oddArray;
    }
	
	public static void main(String[] args) throws IOException
	{
        int arr[] = OddNumberInArray.oddNumbers(5,11);
        System.out.println("Odd number are:");
        for(int i=0; i < arr.length; i++)
        	System.out.println(arr[i]);
    }
}
