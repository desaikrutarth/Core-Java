package General;

import java.util.ArrayList;
import java.util.List;

/*
Given a character limit and a message, split the message up into annotated chunks without cutting words as,
for example:
input: "Hi Sivasrinivas, your Uber is arriving now!"
limit: 25,

Output:
	["Hi Sivasrinivas,(1/3)", "your Uber is arriving(2/3)", "now!(3/3)"]
 */
public class SplitStringByLimit 
{
	public static void splitText(String s,int limit)
	{
		List<String> sentences = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		
		limit = limit-"(x/x)".length();
		String[] words = s.split("\\s+");
		
		for(int i=0;i<words.length;i++)
		{
			StringBuilder sb=new StringBuilder();
			sb.append(words[i]);
			while(i+1<words.length && sb.length()+words[i+1].length()+1<=limit)
			{
				sb.append(" "+words[i+1]);
				i++;
			}
			sentences.add(sb.toString());
		}
		
		int size=sentences.size();
		for(int j=0;j<sentences.size();j++)
		{
			result.add(sentences.get(j) +"("+ (j+1) +"/"+ size +")");
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) 
	{
		String input = "Hi Sivasrinivas, your Uber is arriving now!";
		int limit = 25;
		splitText(input, limit);
	}
}
