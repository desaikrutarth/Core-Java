package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times.
It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times.
Given a string s, determine if it is valid. If so, return YES, otherwise return NO.

For example, if s = abc, it is a valid string because frequencies are {a:1,b:1,c:1}.
So is s = abcc because we can remove one c and have 1 of each character in the remaining string.
If s = abcc however, the string is not valid as we can only remove 1 occurrence of c. That would leave character frequencies of {a:1,b:1,c:2}.

Input: aabbcd -> "NO"
 	   aabbccddeefghi -> "NO"
 	   abcdefghhgfedecba -> "YES"
 */
public class IsValidString
{
	static String isValid(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        List<Integer> values = new ArrayList<>(map.values());

        int prev = values.get(0);
        int curr;
        int count = 0;
        for(int i=1; i<values.size(); i++)
        {
            curr = values.get(i);
            if(Math.abs(curr-prev) > 1)
                return "NO";
            
            if(curr != prev)
            {
                count++;
                if(count > 1)
                    return "NO";
            }
            else
                prev = curr;
        }
        return "YES";
    }
	
	//Method:2
/*	static String isValid(String s)
	{
	    final String GOOD = "YES";
	    final String BAD = "NO";

	    if(s.isEmpty()) return BAD;
	    if(s.length() <= 3) return GOOD;

	    int[] letters = new int[26];
	    for(int i = 0; i < s.length(); i++){
	        letters[s.charAt(i) - 'a']++;
	    }
	    Arrays.sort(letters);
	    int i=0;
	    while(letters[i]==0){
	        i++;
	    }
	    //System.out.println(Arrays.toString(letters));
	    int min = letters[i];   //the smallest frequency of some letter
	    int max = letters[25]; // the largest frequency of some letter
	    String ret = BAD;
	    if(min == max) ret = GOOD;
	    else
	    {
	        // remove one letter at higher frequency or the lower frequency 
	        if(((max - min == 1) && (max > letters[24])) ||
	            (min == 1) && (letters[i+1] == max))
	            ret = GOOD;
	    }
	    return ret;
	}*/
	
	public static void main(String[] args)
	{
		System.out.println(isValid("aabbcd"));
	}
}
