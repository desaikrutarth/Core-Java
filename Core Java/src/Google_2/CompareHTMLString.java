package Google_2;
/*
 * given a html file, compare if two html file show the same contents. 
Eg. 
	<html> <body> <p> H <i> ello </ i> </ p> <body> </ html> is typed as "Hello \ n" without regard to <i> , "\ n" because of <p> 

follow up: what if the string is very long
 */
public class CompareHTMLString 
{
	static boolean compareHTML(String str1, String str2)
	{
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<str1.length(); i++)
		{
			char ch = str1.charAt(i);
			if(ch == '<')
			{
				int pos = str1.indexOf('>',i);
				String substring = str1.substring(i,pos+1);
				
				if(substring.equals("</p>"))
					result.append("\n");
				i = pos;
			}
			else
				result.append(ch);
		}
		return str2.equals(result.toString());
	}
	
	public static void main(String[] args)
	{
		String str1 = "<html><body><p>H<i>ello</i></p></body></html>";
		String str2 = "Hello\n";
		System.out.println(compareHTML(str1,str2));
	}
}
