package Google_2;

import java.util.Arrays;
import java.util.HashMap;
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
		char[] arr1 = String.valueOf(num1).toCharArray();
		char[] arr2 = String.valueOf(num2).toCharArray();
		
		if(arr1.length != arr2.length)
			return false;
		
		return buildPattern(arr1).equals(buildPattern(arr2));
	}
	
	public static String buildPattern(char[] arr)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<arr.length; i++)
		{
			map.put(arr[i], i);
		}
		
		Arrays.sort(arr);
		
		StringBuilder pattern = new StringBuilder();
		for(char ch : arr)
		{
			pattern.append(map.get(ch));
		}
		
		return pattern.toString();
	}
	
	public static void main(String[] args) 
	{
		System.out.println(checkTwoNumber(132, 345));
		System.out.println(checkTwoNumber(333, 555));
		System.out.println(checkTwoNumber(321, 654));
		System.out.println(checkTwoNumber(1221, 2332));
		System.out.println(checkTwoNumber(312, 654));
	}

}
