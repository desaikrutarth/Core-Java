package LeetCode.Easy;


public class RemoveOuterParenthesis
{
	public static String removeOuterParentheses(String S)
	{
		StringBuilder sb = new StringBuilder();
        int open = 0, start = 0;
        for (int i=0; i<S.length(); i++)
        {
            if (S.charAt(i) == '(')
            {
                if (open++ == 0)
                	start = i;
            }
            else
            {
                if (--open == 0)
                	sb.append(S.substring(start+1, i));
            }
        }
        return sb.toString();
    }
	
/*	public static String removeOuterParentheses(String S)
	{
        StringBuilder sb = new StringBuilder();

        int balance = 0;
        int lastbalance = 0;
        for (int i = 0; i < S.length(); i++)
        {
            lastbalance = balance==0 ? 0:1;
            if (S.charAt(i) == '(')
            	balance++;
            else
            	balance--;

            if (balance!=0 && lastbalance!=0)
            	sb.append(S.charAt(i));

        }

        return sb.toString();
    }*/
	
	public static void main(String[] args)
	{
		System.out.println(removeOuterParentheses("(()())(())"));
	}
}
