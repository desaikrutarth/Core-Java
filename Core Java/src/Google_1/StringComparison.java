package Google_1;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * In a native language the increasing order of priority of characters is 
 * a, b, c, d, e, f, g, h, i, j, k, l, m, n, ’ng’ , o, p, q, r, s, t, u, v, w, x, y, z.
 *  You are given two strings string1 and string2 and your task is to compare them on the basis of the given priority order.

 Print ‘0’ if both the strings are equal, ‘1’ if string1 is greater than string2 and ‘-1’ if string1 is lesser than string2.
 All the strings consist of lowercase English alphabets only.
 */
public class StringComparison 
{
	int compare(String s1, String s2)
	{
		String input = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,ng,o,p,q,r,s,t,u,v,w,x,y,z";
		LinkedHashMap<String, Integer> priority = new LinkedHashMap<>();
		
		int count = 1;
		for(String s : input.split(","))
			priority.put(s, count++);
		
        int i = 0;
        int j = 0;
        
        while (i < s1.length() && j < s2.length())
        {
            String x = Character.toString(s1.charAt(i));
            String y = Character.toString(s2.charAt(j));
            
            if (s1.charAt(i) == 'n')
            {
                if ((i+1) < s1.length() && s1.charAt(i+1) == 'g')
                {
                    x = "ng";
                    i++;
                }
            }
            
            if (s2.charAt(j) == 'n')
            {
                if ((j+1) < s2.length() && s2.charAt(j+1) == 'g')
                {
                    y = "ng";
                    j++;
                }
            }
            if (priority.get(x) > priority.get(y))
                return 1;
            
            if (priority.get(x) < priority.get(y))
                return -1;
            i++;
            j++;
        }
        
        if (i < s1.length())
            return 1;
        
        if (j < s2.length())
            return -1;
        
        return 0;
	}
	
	public static void main(String[] args)
	{
		StringComparison obj = new StringComparison();
		String str1 = "addingn";
		String str2 = "adding";
		int res = obj.compare(str1, str2);
		System.out.println(res);
	}
}
