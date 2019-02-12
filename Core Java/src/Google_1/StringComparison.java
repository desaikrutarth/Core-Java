package Google_1;

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
		String[] alphabate = input.split(",");
		
		LinkedHashMap<String, Integer> priority = new LinkedHashMap<>();
		int count = 1;
		for(int i=0; i<alphabate.length; i++)
		{
			priority.put(alphabate[i], count);
			count++;
		}
		
		int n1 = s1.length();
        int n2 = s2.length();
        
        int i = 0;
        int j = 0;
        
        while (i < n1 && j < n2)
        {
            String x = Character.toString(s1.charAt(i));
            String y = Character.toString(s2.charAt(j));
            
            if (s1.charAt(i) == 'n')
            {
                if ((i+1) < n1 && s1.charAt(i+1) == 'g')
                {
                    x = "ng";
                    i++;
                }
            }
            if (s2.charAt(j) == 'n')
            {
                if ((j+1) < n2 && s2.charAt(j+1) == 'g')
                {
                    y = "ng";
                    j++;
                }
            }
            if (priority.get(x) > priority.get(y)){
                return 1;
            }
            if (priority.get(x) < priority.get(y)){
                return -1;
            }
            i++;
            j++;
        }
        
        if (i < n1){
            return 1;
        }
        else if (j < n2){
            return -1;
        }
        else{
            return 0;
        }
	}
	
	public static void main(String[] args)
	{
		StringComparison obj = new StringComparison();
		String str1 = "adding";
		String str2 = "addingng";
		int res = obj.compare(str1, str2);
		System.out.println(res);
	}
}
