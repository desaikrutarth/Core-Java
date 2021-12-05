package LeetCode.Easy;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet and vice versa.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
    
    AB ->28
    Z -> 26
 */
public class ExcelColumnTitle
{
	private static void getExcelColumnByAlpha(String str)
	{
		int result =0 ;
		for(char ch: str.toCharArray())
		{
			int val = (ch -'A') + 1;
			result = (26 * result) + val;
		}
		System.out.println(result);
	}
	
	private static void getExcelColumnByNumber(int num)
	{
		StringBuffer sb = new StringBuffer();
		while(num!=0)
		{
			char ch = (char)((num-1)%26 + 'A');
			num = (num-1)/26;
			sb.insert(0, ch);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args)
	{
		getExcelColumnByAlpha("AB");
		getExcelColumnByNumber(28);
	}
}
