package Google_2;

import java.util.ArrayList;
import java.util.List;
/*
 * In the range of 0-n, return all the numbers that in the reverse can be mistaken for another number. E.g. 18 -> 81.
 * The corner case is not counting the same number, such as 101 and not 0 at the end of the figure such as 60 (because 09 is not 9) 
 */
public class MistakenNumber
{
	public List<Integer> getNum(int num) 
	{
        List<Integer> mistakenList = new ArrayList<Integer>();
        
        if (num <= 11) 
            return mistakenList;
        
        for(int i=12; i<=num; i++)
		{
			String str = String.valueOf(i);
			StringBuilder reverse = new StringBuilder(str);
			reverse.reverse();
			
			if( i% 10 != 0 && !str.equals(reverse.toString()))
				mistakenList.add(i);
		}
        return mistakenList;
    }
        
    public static void main(String[] args) 
    {
        MistakenNumber numbers = new MistakenNumber();
        
        List<Integer> mistaken = numbers.getNum(115);
        System.out.println("running mistaken number");
        for (int n : mistaken) {
            System.out.println(n);
        }
    }
}
