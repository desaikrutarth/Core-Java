package Google_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
/*
 * google-interview-questions3
of 3 votes
20 
Answers
Given two sorted arrays A and B. Find the first K pairs (a, b) from A and B which have the smallest sum of a & b.
Supposed K is small compared to |A| x |B| 
For example: 
A = [1, 2, 3, 6, 10] 
B = [1, 4, 5, 7] 
K = 5 
Result: [(1,1), (2,1), (3,1), (1,4), (1,5)]

 */
public class FindKPairs 
{
	static List<String> getSmallestSums(int[] a, int[] b, int k)
	{
		TreeMap<Integer, String> map = new TreeMap<>();
		List<String> result = new ArrayList<>();
		int i=0;
		int j=0;
		
		while(i < a.length && j < b.length)
		{
			int sum = a[i] + b[j];
			String val = "("+a[i]+","+b[j]+")";
			
			if(map.containsKey(sum))
				val = map.get(sum);
			map.put(sum, val);
			
			if(j == b.length-1)
			{
				i++;
				j=0;
			}
			else
				j++;
		}
		
		int count=0;
		for(String str : map.values())
		{
			count++;
			if(count <= k)
				result.add(str);
			
		}
		return result;
		
	}
	public static void main(String[] args)
	{
		int[] A = {1, 2, 3, 6, 10}; 
		int[] B = {1, 4, 5, 7};
		int	k = 5; 
		
		System.out.println(getSmallestSums(A, B, k));
	}
}
