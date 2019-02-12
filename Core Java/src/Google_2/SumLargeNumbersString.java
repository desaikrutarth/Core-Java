package Google_2;
/*
 *Write a function that takes two numbers as strings and returns the sum as a result as a string: 
Assume the numbers might be too large to be parsed into a variable of any numeric type the language has.
 */
public class SumLargeNumbersString 
{
	static String bigSum(String str1, String str2)
	{
        int lengthS1 = str1.length();
        int lengthS2 = str2.length();

        int diff = Math.abs(lengthS2 - lengthS1);

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < diff; i ++) {
            prefix.append("0");
        }

	//Normilise the length
        if (lengthS1 < lengthS2) 
            str1 = prefix + str1;
        else if (lengthS2 < lengthS1) 
            str2 = prefix + str2;

        StringBuilder out = new StringBuilder();
        int buf = 0;
        for (int i = str1.length() - 1; i >= 0; i--)
        {
            int n1 = Integer.parseInt(String.valueOf(str1.charAt(i)));
            int n2 = Integer.parseInt(String.valueOf(str2.charAt(i)));

            int sum = buf + n1 + n2;
            buf = 0;
            if (sum >= 10)
            {
                sum = sum % 10;
                buf++;
            }
            else 
                buf = 0;

            out.insert(0, sum);
        }

        return buf + out.toString();
    }
	
	public static void main(String[] args)
	{
		String input = "9999";
		String str = "555";
		System.out.println(bigSum(input, str));
	}
}
