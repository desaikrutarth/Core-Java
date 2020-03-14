package practice;
/*
Louise joined a social networking site to stay in touch with her friends.
The signup page required her to input a name and a password. However, the password must be strong.
The website considers a password to be strong if it satisfies the following criteria:

1)Its length is at least 6
2)It contains at least one digit.
3)It contains at least one lowercase English character.
4)It contains at least one uppercase English character.
5)It contains at least one special character. The special characters are: !@#$%^&*()-+
She typed a random string of length  in the password field but wasn't sure if it was strong.
Given the string she typed, can you find the minimum number of characters she must add to make her password strong?

Input:
3
Ab1

Output:
3

Explanation:
She can make the password strong by adding 3 characters, for example, $,h,k turning the password into Ab1$hk which is strong.
2 characters aren't enough since the length must be at least 6.

Input:
11
#HackerRank

Sample Output:
1

Explanation:
The password isn't strong, but she can make it strong by adding a single digit.
 */
public class StrongPassword
{
	 static int minimumNumber(int n, String password)
	 {
	      // Return the minimum number of characters to make the password strong
	      String numbers = "0123456789";
	      String lower_case = "abcdefghijklmnopqrstuvwxyz";
	      String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String special_characters = "!@#$%^&*()-+";
	      int count = 0;
	      
	      if (!contains(password, numbers))
	    	  count++;
	      if (!contains(password, lower_case))
	    	  count++;
	      if (!contains(password, upper_case))
	    	  count++;
	      if (!contains(password, special_characters))
	    	  count++;
	      int delta = Math.max(0, 6 - count - password.length());
	      count += delta;
	      
	      return count;
	 }
	  
    private static boolean contains(String password, String condition)
    {
    	for (char c: condition.toCharArray())
        {
    		if (password.indexOf(c) != -1)
    			return true;
        }
    	return false;
    }
    
    public static void main(String[] args)
    {
    	System.out.println(minimumNumber(11, "#HackerRank"));
	}
}
