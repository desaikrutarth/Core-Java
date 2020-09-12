package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;
/*
Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). 
The string represents the key and the integer represents the value. 
If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, 
and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */
public class MapSumPairs 
{
	static Map<String, Integer> map = new HashMap<>();;
   
    public static void insert(String key, int val)
    {
        map.put(key, val);
        System.out.println(map);
    }
    
    public static int sum(String prefix)
    {
        int sum=0;
        for(String key : map.keySet())
        {
            if(key.startsWith(prefix))
                sum += map.get(key);
        }
        return sum;
    }
    
    public static void main(String[] args)
    {
    	insert("apple", 3);
    	System.out.println("sum = "+sum("ap"));
    	insert("app", 2);
    	System.out.println("sum = "+sum("ap"));
	}
}
