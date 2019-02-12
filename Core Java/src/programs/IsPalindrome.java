package programs;

public class IsPalindrome 
{
	public boolean isPalindrome(int x) 
    {
        String str = Integer.toString(x);
        int left = 0;
        int right = str.length()-1;
        boolean flag = false;
        
        while(left < right)
        {   
            if(str.charAt(right) == str.charAt(left))
                flag = true;
            else
            	flag = false;
            
            right--;
            left++;
        }
        
        return flag;
    }
    
    public static void main(String[] args)
    {
    	IsPalindrome s = new IsPalindrome();
        boolean flag = s.isPalindrome(1221);
        if(flag == true)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
