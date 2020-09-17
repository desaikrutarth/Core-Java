package Google_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given a list of words with lower and upper cases. Implement a function to find all Words that have the same unique character set . 

For example: 
May student students dog studentssess 
god Cat act tab bat flow wolf lambs Amy Yam balms looped poodle john alice 

output: 
may amy 
student students studentssess 
dog god 
cat act 
tab bat 
flow wolf 
lambs balms 
looped, poodle
 */
public class FindWordUniqueChars 
{
	public static void combinationSum(String input) 
	{
	    Map<Set<Character>, Set<String>> map = new HashMap<>();
	    
	    for(String str : input.split(" "))
	    {
	        Set<Character> charSet = str.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.toSet());
	        map.computeIfAbsent(charSet, (s) -> new HashSet<String>()).add(str);
	    }
	    
	    for(Set<String> set : map.values())
	      System.out.println(set);
	}
	
	public static void main(String[] args) 
	{
		String str = "May student students dog studentssess god Cat act tab bat flow wolf lambs Amy Yam balms looped poodle john alice";
		combinationSum(str);
	}
}
