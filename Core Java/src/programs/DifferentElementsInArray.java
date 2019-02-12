package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/*
 * Given two arrays, return the elements in one array that aren't in the other. 
 */
public class DifferentElementsInArray
{
	public static void main(String[] args)
	{
		Integer A[] = {1,2,3,4,5,8,9};
		Integer B[] = {1,2,5,6,7,9};
		
		//Method 1:
		List<Integer> listA = new ArrayList<>(Arrays.asList(A));
		List<Integer> listB = new ArrayList<>(Arrays.asList(B));
		List<Integer> listC = new ArrayList<>(listA);
		
		listA.removeAll(listB);
		listB.removeAll(listC);
		
		System.out.println(listA+" "+listB);
		
		//Method 2:
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		
		for(int i=0; i<A.length; i++)
		{
			tmap.merge(A[i], 1, Integer::sum);
		}
		
		for(int i=0; i<B.length; i++)
		{
			tmap.merge(B[i], 1, Integer::sum);
		}
		
		for(int item : tmap.keySet())
		{
			int val = tmap.get(item);
			if(val == 1)
				System.out.print(item+" ");
		}
		
	}
}
