package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams 
{
	static List<Integer> findAnagrams(String str, String anagram) 
	{
		List<Integer> list = new ArrayList<>();
		int j = anagram.length();
		char[] anagramArray = anagram.toCharArray();
		
		Arrays.sort(anagramArray);		
        for(int i=0; i<str.length()-anagram.length()+1; i++)
        {
        	String substring = str.substring(i, j);
        	char[] chArray = substring.toCharArray();
        	Arrays.sort(chArray);
        	
        	if(Arrays.equals(chArray, anagramArray))
        		list.add(i);
        	j++;
        }
        return list;
    }
	public static void main(String[] args) 
	{
		String str = "cbaebabacd";
		String anagram = "abc";
		System.out.println(findAnagrams(str, anagram));
	}
}
