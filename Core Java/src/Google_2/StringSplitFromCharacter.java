package Google_2;
/*
 * 
text is an input string, characters on behalf of the output of each line up to the number of bytes.
If word is incomplete than split it from the previous space. 
input:
	"Thank you for shopping at the XYZ store.\n Your order has been processed successfully.\n", 20
output：
        "Thank you for\n
        shopping at the XYZ\n
        store.\n
        Your order has been\n
        processed\n
        Successfully.\n"

example 2:"Hello! How are you?", 6
output:
	Hello!\n
	How\n
	are\n
	you?\n"
 */
public class StringSplitFromCharacter 
{
	public static void wrapText(String text, int characters)
	{
		int count=0;
		int start=0;
		int end = 0;
		for(int i=0; i<text.length(); i++)
		{
			char ch = text.charAt(i);
			
			if(i == text.length()-1)
			{
				System.out.println(text.substring(start, text.length()));
				break;
			}
			
			if(count < characters)
			{
				if(ch == ' ')
					end = i;
				count++;
			}
			else
			{
				if(ch == ' ')
				{
					System.out.println(text.substring(start,i));
					start = i;
				}
				else
				{
					System.out.println(text.substring(start,end+1));
					start = end+1;
					i = end;
				}
				count=0;
			}
		}
	}
	
	/*public static void wrapText(String text, int characters)
	{
		int start = 0;
		int end = 0;
		int counter = 0;
		for (int i = 0; i < text.length(); i++) 
		{
			if(i == text.length()-1)
			{
				System.out.println(text.substring(start, text.length()));
				break;
			}
			if(counter< characters)
			{
				if(text.charAt(i)==' ')
					end = i;
				counter++;
			}
			else
			{
				if(text.charAt(i) == ' ')
				{
					System.out.println(text.substring(start, i));
					start = i+1;
					end =i+1;
				}
				else
				{
					System.out.println(text.substring(start, end));
					start = end+1;
					i = end;
					end = start;
				}
				counter = 0;
			}	
		}
	}*/
	
	 public static void main(String args[]) 
	 {
		 String str1 ="Hello! How are you?";
		 wrapText(str1, 6);
	        
	 }
}
