package Google_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * You are given an array of strings. For example, ["AB", "BC", "FOO", "ZA", "BAZ"] 
- Output strings where you can get from one to the other using any ROT transformation. 

ROT_1(AB) = BC 
ROT_1(BC) = CD 
ROT_25(AB) = ZA 
AB,BC you can go from one to the other using ROT_1 
Input: list of strings 
Output: strings where you can get from one to the other using any ROT transformation. 
Example: 
	Input : ["AB", "BC", "FOO", "ZA", "BAZ"] 
	Output: [ [ab, bc] , [ab, za] ] 
AB,BC because you can go from one to the other using ROT_1 
AB,ZA because you can go from one to the other using ROT_25 
Do not return FOO, BAZ you can’t get from one to the other.
 */
public class AlphabatesOrdering 
{
	public static void rotTrans(String [] list)
	{	
		ArrayList<String> wordList = new ArrayList<>(Arrays.asList(list));
		Map<String, String> map = new LinkedHashMap<>();
		Set<Set<String>> resultSet = new HashSet<>();
		
		for(int i=0; i<26; i++)
		{
			char c1 = (char)('A'+i);
			char c2 = (char)(c1=='Z'?'A':c1+1);
			char c3 = (char)(c2=='Z'?'A':c2+1);
			
			String str1 = c1+""+c2;
			String str2 = c2+""+c3;
			
			map.put(str1, str2);
		}
		
		for(String word : wordList)
		{
			if(map.containsKey(word) && wordList.contains(map.get(word)))
			{
				HashSet<String> set = new HashSet<>();
				set.add(word);
				set.add(map.get(word));
				resultSet.add(set);
			}
		}
		System.out.println(resultSet);
	}
	/*public static void rotTrans(String [] list)
	{		
			HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
			String key;
			int len = 0,i = 0, j = 0;
			
			for(String s: list)
			{
				key = keyGen(s);
				if(map.containsKey(key))
					map.get(key).add(s);
				else
				{
					map.put(key, new ArrayList<String>());
					map.get(key).add(s);
				}
			}
			for(String k : map.keySet())
				len += map.get(k).size() - 1;
			
			String [][] result = new String [len][2];
			
			for(Map.Entry<String,ArrayList<String>> entry : map.entrySet())
			{
				if(entry.getValue().size() > 1)
				{
					for(j = 1; j < entry.getValue().size(); j++)
					{
						result[i][0] = entry.getValue().get(0);
						result[i][1] = entry.getValue().get(j);
						i++;
					}
				}
			}
			System.out.println(Arrays.deepToString(result));
		}
		
		public static String keyGen(String str)
		{
			if(str.length() <= 1) return "1";
			
			StringBuilder sb = new StringBuilder();
			char ch1,ch2;
			ch1 = str.charAt(0);
			for(int i = 1; i < str.length(); i++)
			{
				ch2 = str.charAt(i);
				if(ch2 >= ch1) 
				{
					int num = ch2 - ch1;
					sb.append(num);
				}
				else
				{
					int n= ch1 - 'Z' + 1;
					sb.append(n);
				}
				ch1 = ch2;
			}
			return sb.toString();
		}*/
		
		public static void main(String[] args)
		{
			String[] list = {"AB", "BC", "FOO", "ZA", "BAZ"};
			rotTrans(list);
		}
}
