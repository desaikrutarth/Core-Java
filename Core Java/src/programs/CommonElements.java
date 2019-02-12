package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CommonElements 
{
	public static void main(String[] args)
	{
		Integer a[] = {1,2,3,4,5};
		Integer b[] = {3,4,5,6,7};
		
		ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(a));
		ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(b));
		
		listA.retainAll(listB);
		System.out.println(listA);
		
		//System.out.println(listA.stream().filter(c -> listB.contains(c)).collect(Collectors.toList()));
	}
}
