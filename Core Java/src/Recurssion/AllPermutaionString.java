package Recurssion;

public class AllPermutaionString
{

	//Method : 1
	static void permutation(String permute, String str)
	{
		if(str.length()==0)
		{
			System.out.println(permute);
			return;
		}
			
		for(int i=0; i<str.length();i++)
		{
			String p = permute + str.charAt(i);
			String s = str.substring(0,i) + str.substring(i+1,str.length());
			permutation(p,s); 
		}
	}
	/**
     * permutation function
     * @param str string to calculate permutation for
     * @param lb starting index
     * @param ub end index
     */
/*    private void permute(String str, int lb, int ub)
    {
        if (lb == ub)
            System.out.println(str);
        else
        {
            for (int i = lb; i <= ub; i++)
            {
                str = swap(str,lb,i);
                permute(str, lb+1, ub);
                str = swap(str,lb,i);
            }
        }
    }
 
    public String swap(String s, int i, int j)
    {
        char[] charArray = s.toCharArray();
        char temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }*/
    
    public static void main(String[] args)
    {
    	permutation("","ABC");
     /*   AllPermutaionString permutation = new AllPermutaionString();
        String str = "ABC";
        int n = str.length();

        permutation.permute(str, 0, n-1);*/
    }
}
