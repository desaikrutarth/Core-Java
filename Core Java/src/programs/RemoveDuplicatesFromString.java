package programs;

import java.util.Arrays;

public class RemoveDuplicatesFromString
{
	static String removeDupsSorted(String str)
    {
        int res_ind = 1, ip_ind = 1;
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        /* In place removal of duplicate characters*/
        while (ip_ind != arr.length)
        {
            if(arr[ip_ind] != arr[ip_ind-1])
            {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;
           
        }
     
        str = new String(arr);
        return str.substring(0,res_ind);
    }
      
    // Driver Method
    public static void main(String[] args)
    {
        String str = "abbacca";
        System.out.println(removeDupsSorted(str));
    }
}
