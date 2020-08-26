package FaceBook;

public class MultiplyLargeNumbers
{
	public static String multiply(String num1, String num2)
	{
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        
        int size1 = num1.length(), size2 = num2.length();
        int[] result = new int[size1 + size2];
        
        for (int i = size1 - 1; i >= 0; i--)
        {
            int x = Character.getNumericValue(num1.charAt(i));
            for (int j = size2 - 1; j >= 0; j--)
            {
                int y = Character.getNumericValue(num2.charAt(j));
                int pos1 = i + j + 1;
                int pos2 = i + j;
                int prod = x * y;
                result[pos1] += prod % 10;
                result[pos2] += prod / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--)
        {
            if (i == 0 && result[i] == 0)
                continue;
            sb.insert(0, result[i] % 10);
            if (result[i] >= 10)
                result[i-1] += result[i] / 10;
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(multiply("123", "11"));
	}
}
