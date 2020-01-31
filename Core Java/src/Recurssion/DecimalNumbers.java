package Recurssion;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 Give a decimal number, such as 123. Asking a total of smaller num than 123 made up by 1 and 0 composed of decimal numbers. 
111, 110, 101, 100, 11, 10, 1, 0.
 */
public class DecimalNumbers
{
	static Set<Integer> printAll(int num)
	{
		Set<Integer> set = new HashSet<>();
		set.add(0);
		printAllHelper("1",num,set);
		return set;
	}
	
	static void printAllHelper(String str, int num, Set<Integer> set)
	{
		int val = Integer.parseInt(str);
		if(val > num)
			return;
		
		set.add(val);
		printAllHelper(str+"0", num, set);
		printAllHelper(str+"1", num, set);
	}
	
    public static void main(String[] args)
    {
    	System.out.println(printAll(123));
    }
}
