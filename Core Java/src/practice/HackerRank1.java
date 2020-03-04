package practice;

import java.util.Arrays;
import java.util.HashMap;

public class HackerRank1
{
	public static String[] getDeviceCount(String[] devices)
	{
		HashMap<String, Integer> map = new HashMap<>();
		String[] result = new String[devices.length];

		for(int i=0; i<devices.length; i++)
		{
			String str = devices[i];
			
			if(map.containsKey(str))
				result[i] = str + map.get(str);
			else 
				result[i] = str;
			
			map.merge(str, 1, Integer::sum);
		}
		return result;
	}
	
/*	public static String reverseString(String input)
	{
		StringBuffer sb = new StringBuffer();
		for(char ch: input.toCharArray())
		{
			if(ch=='A')
				sb.append('T');
			else if(ch=='T')
				sb.append('A');
			else if(ch=='G')
				sb.append('C');
			else if(ch =='C')
				sb.append('G');
		}
		return sb.reverse().toString();
	}
*/
	public static void main(String[] args)
	{
		String[] devicenames = {"switch", "tv","switch", "tv","switch", "tv"};
		System.out.println(Arrays.toString(getDeviceCount(devicenames)));
//		System.out.println(reverseString("ACCGGGTTTT"));
	}
}
