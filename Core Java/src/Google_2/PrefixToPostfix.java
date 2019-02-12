package Google_2;

public class PrefixToPostfix
{
	public static String preToPost(String str)
	{
	    if(str.length() <= 1){
	        return str;
	    }

	    if(!Character.isLetter(str.charAt(0)))
	    {
	        String a = preToPost(str.substring(1)) + str.charAt(0);
	        String b = preToPost(str.substring(a.length()));
	        return a + b;
	    }
	    else if(!Character.isLetter(str.charAt(1)))
	        return str.substring(0,1);
	    else
	        return str.substring(0,2);
	    
	}
	
	public static void main(String[] args)
	{
		String str = "+ * A B / C D -> A B * C D / +";
		System.out.println(preToPost(str));
	}
}
