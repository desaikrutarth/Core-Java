package programs;

import java.util.*;

public class JavaRegex 
{
	 public static void main(String[] args)
	 {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter String");
	        String s = scan.nextLine();
	        // Write your code here.
	        String split[] = s.split("[\\s,?'!._@]");
	        List<String>list = new ArrayList<String>();

	        for(int i=0; i<split.length; i++)
	        {
	            if(!split[i].equals(""))
	            {
	                System.out.println(split[i]);
	                list.add(split[i]);
	            }               
	        }
	        System.out.println(list.size());
	        scan.close();
	    }
}
