package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 0 change to 01,1 change to 10. 
Line 0 is 0, the first line is 01, the second line is 0110, the third line 01101001. . .
Keep asking what is the vale at kth row and jth col
 */
public class PrintSeries0s1s 
{
	public static List<Integer> build(List<Integer> list, int level)
	{
		if(level == 0)
			return list;
		List<Integer> newList = new ArrayList<Integer>();
		for(int each:list)
		{
			if(each == 0)
			{
				newList.add(0);
				newList.add(1);
			}
			else
			{
				newList.add(1);
				newList.add(0);
			}
		}
		return build(newList,level-1);
	}
	
	
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>(Arrays.asList(0));
		System.out.println(build(list,3));
		

	}
}
