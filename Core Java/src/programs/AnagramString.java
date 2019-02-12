
package programs;

import java.util.*;
import java.util.stream.Collectors;

class AnagramString
{
	private static boolean isAnagram(String a, String b)
	{
		List<Character> listA = a.chars().mapToObj(c->(char)c).sorted().collect(Collectors.toList());
		List<Character> listB = b.chars().mapToObj(c->(char)c).sorted().collect(Collectors.toList());
		
		return listA.equals(listB);
	}	
	/*static boolean isAnagram(String a, String b)
	{
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		
		Arrays.sort(charA);
		Arrays.sort(charB);
		
		if(Arrays.equals(charA, charB))
			return true;
		return false;
	    
    }*/
	
	public static void main(String[] args)
	{
	    
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first string");
        String a = scan.next();
        a = a.toLowerCase();
        
        System.out.println("Enter second string");
        String b = scan.next();
        b = b.toLowerCase();
        scan.close();
        
        boolean ret =  isAnagram(a, b);
       
        if(ret == true)
        	System.out.println("Anagram");
        else
        	System.out.println("Not Anagram");
    }

}



	

