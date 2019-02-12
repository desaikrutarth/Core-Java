package programs;
import java.util.*;

public class IntegerHashMap
{
	public static void main(String[] args)
	{
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("enter five values");
		int arr[] = new int[5];
		int i;
	
		for(i=0; i<arr.length; i++)
		{
			arr[i] = s.nextInt();
		}
		
		for(i=0; i<arr.length; i++)
		{
			if(hmap.containsKey(arr[i]))
			{
				hmap.get(arr[i]);
				int j = hmap.get(arr[i]);
				j++;
				hmap.put(arr[i],j);
			}
			else
			{
				hmap.put(arr[i],1);
			}
		}
		System.out.println(hmap);
	}
}
