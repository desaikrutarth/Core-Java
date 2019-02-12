package programs;

import java.util.*;

public class NextBiggestNumber
{
		List<String> list = new  ArrayList<String>();
		private List<String> permute(String str, int l, int r)
		{	
	        if (l == r)
	            list.add(str);
	        else
	        {
	            for (int i = l; i <= r; i++)
	            {
	                str = swap(str,l,i);
	                permute(str, l+1, r);
	                str = swap(str,l,i);
	            }
	        }
	        return list;
	   }
	 
	    public String swap(String s, int i, int j)
	    {
	        char temp;
	        char[] charArray = s.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
	    
	    public static void main(String[] args)
	    {
	    	NextBiggestNumber next = new NextBiggestNumber();
	        String str = "1234";
	        int n = str.length();

	        List<String> list  =next.permute(str, 0, n-1);
	        Collections.sort(list, Collections.reverseOrder());
	        System.out.println("Next biggest number = "+list.get(1));
	    }
}
