package programs;

import java.util.*;

public class StringToken
{
	public static void main(String[] args)
	{
      //  Scanner scan = new Scanner(System.in);
        String s = "He is a very very good boy, isn't he?";
        // Write your code here.
        String[] split = s.split("\\s|,\\s|'|;|\\.|\\?|\\s!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/|\\t");
        System.out.println(split.length);
        for(int i = 0; i < split.length; i++)
        {           
            System.out.println(split[i]);
        }
      //  scan.close();
    }
}
