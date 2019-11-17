package Google_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 * Judge if two arrays has the same pattern, 
The definition is the relative relationship between each number and other numbers are the same,
such as 132, 354, the first number is less than the second, the first less than the third, the second is greater than the third, 
So is the same, 
132,352 is not the same, because the first 132 is less than the third, the first 352 is greater than the second, 
follow up, the array may concern duplicates
 */
public class ArrayPatternDetect 
{
	public static boolean checkTwoNumber(int num1, int num2) 
	{
		char[] arr1 = Integer.toString(num1).toCharArray();
		char[] arr2 = Integer.toString(num2).toCharArray();
		
		if(arr1.length != arr2.length)
			return false;
		
		LinkedHashMap<Character, Integer> hmap1 = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> hmap2 = new LinkedHashMap<>();
		
		for(int i=0; i<arr1.length; i++)
		{
			hmap1.put(arr1[i], i);
			hmap2.put(arr2[i], i);
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		StringBuilder pattern1 = new StringBuilder();
		StringBuilder pattern2 = new StringBuilder();
		
		for(int i=0; i<arr1.length; i++)
		{
			pattern1.append(hmap1.get(arr1[i]));
			pattern2.append(hmap2.get(arr2[i]));
		}
		
		return pattern1.toString().equals(pattern2.toString());
	}
	
	public static void main(String[] args) 
	{
//		System.out.println(checkTwoNumber(132, 354));
		System.out.println(checkTwoNumber(333, 555));
		System.out.println(checkTwoNumber(321, 654));
		System.out.println(checkTwoNumber(1221, 2332));
		System.out.println(checkTwoNumber(312, 654));
	}

}
