package Recurssion;
import java.util.ArrayList;
import java.util.List;

public class FindAllBinary 
{
	static List<String> allBinaryStrings(int k)
	{
        char[] arr = new char[k];
        List<String> res = new ArrayList<>();

        StringBuilder initString = new StringBuilder();
        for (int i = 0; i < k; i++){
            initString.append("0");
        }

        allBinaryStringHelper(res, arr, 0, initString.toString());

        return res;
    }

	static void allBinaryStringHelper(List<String> res, char[] arr, int index, String initString) 
	{

        if (index >= arr.length) 
        {
            StringBuilder t = new StringBuilder();
            for (char c : arr) {
                t.append(c);
            }
            res.add(t.toString());
            return;
        }

        char current = initString.charAt(index);
        char[] charSet = new char[]{'0', '1'};
        if (current == '0') 
        {
            for (char aCharSet : charSet) 
            {
                arr[index] = aCharSet;
                allBinaryStringHelper(res, arr, index + 1, initString);
            }
        }

        if (current == '1')
        {
            for (char aCharSet : charSet)
            {
                arr[index] = aCharSet;
                allBinaryStringHelper(res, arr, index + 1, initString);
            }
        }
    }
    
    public static void main(String[] args)
    {
    	System.out.println(allBinaryStrings(2));
    }
}
