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

public class SortMapAscDesc
{
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
