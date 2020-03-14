package practice;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 Example 1:
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:
Input: "/a/./b/../../c/"
Output: "/c"

Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */
public class Practice { // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static void main(String[] args)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// sort Hashmap by value in desc order
		map = map.entrySet()			
	        	.stream()
	        	.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))		        	
	        	.collect(
	        			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)
	        			);
		
		//sort map by value asc
		map = map.entrySet()		
	            .stream()
	            .sorted(Map.Entry.comparingByValue())
	           . collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
	}

}
