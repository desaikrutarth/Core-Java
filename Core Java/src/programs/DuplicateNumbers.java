package programs;
import java.util.*;
public class DuplicateNumbers
{
	public static void main(String[] args)
	{
		int arr[] = {1,1,2,2,2,3,3,3,3,4};
		ArrayList<Integer> uniqueList = new ArrayList<>();
		
		for(int i=1; i < arr.length; i++)
		{
			if(arr[i] != arr[i-1])
				uniqueList.add(arr[i-1]);
			
			if(i == arr.length-1)
				uniqueList.add(arr[i]);
		
		}
		
		System.out.println(uniqueList);
	}
}
