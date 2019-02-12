package programs;

/* You are given a string of 0’s and 1’s you have to find the number of substrings in the string which starts and end with a 1.
eg : input : 0010110010
 	 output : 6
*/
public class NumberOfSubstrings 
{
	// Method 1: O(n)
	public void Substrings(String str)
	{
		int i=0;
		int j=i+1;
		
		while(i < str.length() && j < str.length())
		{
			if(str.charAt(i) == '1' && str.charAt(j)=='1')
			{
				String subString = str.substring(i, j+1);
				System.out.println(subString);
			}
			if(j == str.length()-1)
			{
				i++;
				j=i+1;
			}
			else
				j++;
		}
	}
	
	// Method 2: O(n)
	//a) Count the number of 1’s. Let the count of 1’s be m.
	//b) Return m(m-1)/2
	void countSubStr(String str) 
    {
        int m = 0; // Count of 1's in input string

        // Travers input string and count of 1's in it
        for (int i = 0; i < str.length(); i++) 
        {
            if (str.charAt(i) == '1')
            m++;
        }

        // Return count of possible pairs among m 1's
        m =  m * (m - 1) / 2;
        System.out.println("Number of substring = "+m);
    }
	
	public static void main(String[] args)
	{
		NumberOfSubstrings num = new NumberOfSubstrings();
		String input = "0010110010";
		num.Substrings(input);
	//	num.countSubStr(input);
	}
}
