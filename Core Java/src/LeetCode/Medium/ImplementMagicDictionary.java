package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Design a data structure that is initialized with a list of different words. 
Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.

Implement the MagicDictionary class:

MagicDictionary() Initializes the object.
void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure,
otherwise returns false.

Example 1:

Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False
 */
public class ImplementMagicDictionary 
{
	static Map<Integer, ArrayList<String>> buckets = new HashMap<>();

    public static void buildDict(String[] words)
    {
        for (String word: words) 
        {
            buckets.computeIfAbsent(word.length(), x -> new ArrayList<>()).add(word);
        }
        System.out.println(Arrays.toString(words));
    }

    public static boolean search(String word)
    {
        if (!buckets.containsKey(word.length())) 
        	return false;
        List<String> valList = buckets.get(word.length());
        for (String candidate : valList) 
        {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i)
            {
                if (word.charAt(i) != candidate.charAt(i))
                {
                    if (++mismatch > 1) 
                    	break;
                }
            }
            if (mismatch == 1) 
            	return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
    	buildDict(new String[] {"hello", "leetcode"});
    	System.out.println(search("hello"));
    	System.out.println(search("hhllo"));
    	System.out.println(search("hell"));
    	System.out.println(search("leetcoded"));
	}
}
