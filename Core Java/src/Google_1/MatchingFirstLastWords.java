package Google_1;

import java.util.HashMap;
import java.util.LinkedHashSet;

/*
 * For example: 
Input: ['OF MICE AND MEN', 'BLACK MASS', 'MEN IN BLACK"]
Output:  'OF MICE AND MEN IN BLACK MASS'

Explanation:
'OF MICE AND MEN' and 'MEN IN BLACK' join to form 'OF MICE AND MEN IN BLACK'. 
You could further join 'OF MICE AND MEN IN BLACK' with 'BLACK MASS' to form 'OF MICE AND MEN IN BLACK MASS'. 
 */
public class MatchingFirstLastWords 
{
	static void mergeStrings(String[] input)
	{
		HashMap<String, String> headMap = new HashMap<>();
		for (int i=1; i<input.length; i++) 
		{
			String str = input[i];
			String[] strArr = input[i].split(" +");
			headMap.put(strArr[0], str);
		}
		
		String s=input[0];
		String result = s;
		
		while (!headMap.isEmpty()) 
		{
			String[] strArr = s.split(" +");
			String tail = strArr[strArr.length - 1];
			s = headMap.get(tail);
			result += s.substring(tail.length());
			headMap.remove(tail);
		}
		System.out.println(result);
	}
	
//	Method2: O(n^2)
//	static void mergeStrings(String[] arr)
//	{
//
//		LinkedHashSet<String> set = new LinkedHashSet<>();
//		String newString = "";
//		for(int i=0; i < arr.length; i++)
//		{
//			for(int j = i+1; j < arr.length; j++)
//			{
//				String prevStr = arr[i];
//				String prevfirstWord = prevStr.substring(0, prevStr.indexOf(' '));
//				String prevLastWord = prevStr.substring(prevStr.lastIndexOf(" ")+1);
//				
//				
//				String nextStr = arr[j];
//				String nextFirstWord = nextStr.substring(0, nextStr.indexOf(' '));
//				String nextLastWord = nextStr.substring(nextStr.lastIndexOf(" ")+1);
//				
//				if(prevfirstWord.equals(nextLastWord))
//					newString += " " + nextStr + prevStr.substring(prevStr.indexOf(' '));
//				
//				if(prevLastWord.equals(nextFirstWord))
//					newString += " " + prevStr + nextStr.substring(nextStr.indexOf(' '));							
//			}
//					
//		}
//		
//		for(String word : newString.split(" ")) {
//			set.add(word);
//		}
//		
//		String result = " ";
//		for(String word : set) {
//			result += word+" ";
//		}
//		
//		System.out.println(result);
//		
//	}
	
	public static void main(String[] args)
	{
		String[] str = {"OF MICE AND MEN", "BLACK MASS", "MEN IN BLACK", "MASS OF PLUTO"};
		mergeStrings(str);
	}
}
