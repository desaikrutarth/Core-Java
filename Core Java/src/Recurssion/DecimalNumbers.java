package Recurssion;
import java.util.Set;
import java.util.Stack;

/*
 Give a decimal number, such as 123. Asking a total of smaller num than 123 made up by 1 and 0 composed of decimal numbers. 
111, 110, 101, 100, 11, 10, 1, 0.
 */
public class DecimalNumbers
{
	
    static void printAll(String str,int n)
    {
        int val= Integer.valueOf(str);
        if(val > n)
            return;
        else
        {
            System.out.println(val); 
            if(val!=0)
            {
                printAll(str+"1",n);
                printAll(str+"0",n);
            }           
         
        }
    }
    //Method 2
    static void print(int num)
    {
    	for(int i=0; i<num; i++)
    	{
    		String str = String.valueOf(i);
    		if(str.startsWith("1") && !str.contains("2"))
    		{
    			if(str.endsWith("1") || str.endsWith("0"))
    			System.out.println(str);
    		}
    			
    	}
    }
	
    public static void main(String[] args)
    {
    	printAll("0",123);
        printAll("1",123); 
        
    //	print(123);
    }
}
