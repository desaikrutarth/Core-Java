package LeetCode.Easy;

import java.util.HashMap;

/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false
 */
public class PatternMatchingWord 
{
	static boolean wordPattern(String pattern, String str)
	{    
        HashMap<Character,String> map = new HashMap<>();
        String strArray[] = str.split(" ");
        
        if(strArray.length != pattern.length())
            return false;
        
        for(int i=0; i < strArray.length; i++)
        {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch))
            {
            	String val = map.get(ch);
                if(!val.equals(strArray[i]))
                    return false;
            }
            else
            {
            	if(map.containsValue(strArray[i]))	// if 2 keys have same value
            		return false;
                 map.put(ch,strArray[i]);     
            }
        }

        return true;
	}
	/*static boolean wordPattern(String pattern, String str)
	{
		HashMap<Character, Integer> patternMap = new HashMap<>();
		HashMap<String, Integer> strMap = new HashMap<>();
		
		StringBuilder patternBuild = new StringBuilder();
		StringBuilder strBuilder = new StringBuilder();
		
		for(int i=0; i<pattern.length(); i++)
		{
			if(patternMap.containsKey(pattern.charAt(i)))
			{
				int val = patternMap.get(pattern.charAt(i));
				patternBuild.append(val);
				patternMap.put(pattern.charAt(i), val);
			}
			else
			{
				patternMap.put(pattern.charAt(i), i);
				patternBuild.append(i);
			}
		}
		
		int index = 0;
		for(String s : str.split(" "))
		{
			if(strMap.containsKey(s))
			{
				int val = strMap.get(s);
				strBuilder.append(val);
				strMap.put(s, val);
			}
			else
			{
				strMap.put(s, index);
				strBuilder.append(index);
			}
			index++;
		}
		
		return strBuilder.toString().equals(patternBuild.toString());
	}*/
	
	public static void main(String[] args) 
	{
		String pattern = "abba";
		String str = "dog cat cat dog";
		
		System.out.println(wordPattern(pattern,str));
	}

	
}
