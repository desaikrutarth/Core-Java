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
	public static String mergeStrings(String[] strArray)
	{
		HashMap<String, String> map = new HashMap<>();

		for(int i=1; i<strArray.length; i++)
		{
			String word = strArray[i];
			String head = word.substring(0, word.indexOf(' '));
			map.put(head, word);
		}

		String result = strArray[0];
		String first = strArray[0];

		while(!map.isEmpty())
		{
			String lastWord = first.substring(first.lastIndexOf(' ')+1);
			first = map.get(lastWord);
			result += first.substring(lastWord.length());
			map.remove(lastWord);
		}
		return result;
	}
	
/*	static String mergeStrings(String[] input)
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
		return result;
	}*/
	
	public static void main(String[] args)
	{
		String[] str = {"OF MICE AND MEN", "BLACK MASS", "MEN IN BLACK", "MASS OF PLUTO"};
		System.out.println(mergeStrings(str));
	}
}
