package Recurssion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllBinary 
{
	static Set<String> allBinaryStrings(int k)
	{
		Set<String> res = new HashSet<>();
		allBinaryHelper("0","1",k,res);
		return res;
	}
    
    private static void allBinaryHelper(String zero, String one, int k, Set<String> res)
    {
    	if(zero.length() == k)
    	{
    		res.add(zero);
    		return;
    	}
    	
    	if(one.length() == k)
    	{
    		res.add(one);
    		return;
    	}
    	
		allBinaryHelper(zero+"0", one, k, res);
		allBinaryHelper(zero+"1", one, k, res);
		
		allBinaryHelper(zero, one+"0", k, res);
		allBinaryHelper(zero, one+"1", k, res);
	}
    
	/*static List<String> allBinaryStrings(int k)
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
    }*/

	public static void main(String[] args)
    {
    	System.out.println(allBinaryStrings(2));
    }
}
