package Recurssion;
import java.util.ArrayList;
/*
Find all the abbreviations of string: 
Eg: 
	ABC 
	SOME Valid abbreviations are : 
		1BC 
		2C 
		3 
		A1C 
		AB1 
		A2 
	NOT VALID: 
		11C(two numbers cannot occur continuously)
 */
public class FindAllAbbreviationsString
{
	static ArrayList<String> abbreviation(String s)
	{
        if (s.length() == 1)
        {
            ArrayList<String> res = new ArrayList<>();
            res.add("1");
            res.add(s);
            return res;
        }
        char curr = s.charAt(0);
        ArrayList<String> prev = abbreviation(s.substring(1));
        ArrayList<String> result = new ArrayList<>();
        for (String p : prev)
        {
            char first = p.charAt(0);
            if (first >= '0' && first <= '9')
            { // it's a number
                if (first < '9')
                {
                    Integer newNr = Integer.valueOf(first + "") + 1;
                    result.add(newNr + p.substring(1));
                }
                result.add(curr + p);
            }
            else
            {
                result.add(curr + p);
                result.add("1" + p);
            }
        }
        return result;
	}
	
	 public static void main(String[] args)
	 {
		 System.out.println(abbreviation("abc"));
	 }
}