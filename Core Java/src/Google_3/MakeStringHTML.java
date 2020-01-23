package Google_3;

import java.util.Arrays;
import java.util.List;
/*
Write a program which will bold the sub-string found in string (HTML Style).

Example: string = "HelloWorld HelloWorld"
substringList = ["el", "rl"]

Make it like HTML Style:- 
NewString = "H<b>el</b>loWo<b>rl</b>d H<b>el</b>loWo<b>rl</b>d

 */
public class MakeStringHTML
{
	public static String makeBold(String str, List<String> sub)
	{
		for(String substring : sub)
		{
			if(str.contains(substring))
			{
				str = str.replaceAll(substring, "<b>"+substring+"</b>");
			}
				
		}
		return str;
	}
	
	public static void main(String[] args)
	{
		System.out.println(makeBold("HelloWorld HelloWorld", Arrays.asList("el", "rl")));
	}
}
