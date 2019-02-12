package programs;

import java.util.Scanner;

public class Reverse 
{

	public static String reverse()
	{
		String n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String");
		n = s.nextLine();	
		System.out.println(n);
		char [] ch = new char[n.length()];
		char [] charr = n.toCharArray(); 
		int k=0;
		
    for (int i = n.length()-1; i >= 0; i--)
    {
    	ch[k] = charr[i];
    	k++;

    }
    
    String str = new String(ch);
    
    return str;
		
	} 
	
	public static void main(String args[])
	{
	  String str = reverse();
	  System.out.println(str);
	  
	}

}
