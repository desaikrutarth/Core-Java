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
		String result = " ";
		for(String part : sub)
		{
			if(str.contains(part))
			{
				result = str.replaceAll(part, "<b>"+part+"</b>");
				str = result;
			}
		}
		return result;
	}
	
	/*public static String makeBold(String s, List<String> sub)
	{
		for(String eachSub : sub)
		{
			String[] parts = s.split(eachSub);
			StringBuilder sb = new StringBuilder();	
			String insert = new StringBuilder("<b>").append(eachSub).append("</b>").toString();	
			for(int i = 0; i < parts.length ; i++)
			{
				sb.append(parts[i]);
				if(i < parts.length -1)
					sb.append(insert);
			}
			s = sb.toString();
		}
		return s;
	}*/
	
	public static void main(String[] args) {
		System.out.println(makeBold("HelloWorld HelloWorld", Arrays.asList("el", "rl")));
	}
}
