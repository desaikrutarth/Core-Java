package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HackerRankString
{
	public static boolean hackerrankInString(String s)
	{
        String keyword = "hackerrank";
        int keyInd = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == keyword.charAt(keyInd))
                ++keyInd;
            
            if (keyInd == keyword.length())
                return true;
        }
        return false;
    }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(hackerrankInString("hereiamstackerrank"));
	 }
}
