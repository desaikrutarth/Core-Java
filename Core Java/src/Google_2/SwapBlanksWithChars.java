package Google_2;
/*
Giving start string and end string, determine if start string can finally reach to the same as end string with below rules. 
For example: 
"R L _ _ L R L" 
"_": the space is empty 
"L": this can only swap with the empty letter _ on its left side 
"R": this can only swap with the empty letter _ on its right side 
So, "R L _ _ L R L" can change to "R L _ L _ R L" , and can continue change to (if you want) "R L L _ _ R L". from: 1point3acres.com/bbs 
The question is given these rules and the start string and end string, could we change the start string to end string (unlimited # moves as long as it is valid). 
For example: 
"R _ _ L R _ R _L" 
can be changed to 
"_ R L _ _ R R L _"
 */
public class SwapBlanksWithChars
{
	static StringBuilder swappedStr = new StringBuilder();
	static String swapEmptySpace(String str)
	{		
		String swapped = "";
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == 'R' && str.charAt(i+1) == '_')
			{
				int j = i+1;
				swapped = swap(str,i,j);
			}
			
			if(str.charAt(i) == 'L' && str.charAt(i-1) == '_')
			{
				int j = i-1;
				swapped = swap(str,i,j);
			}
				
		}
		return swapped;
	}
	
	static String swap(String s, int i, int j)
	{
		
		char[] charArray = s.toCharArray();
		char tmp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = tmp;		
		
		if(i < j)
		{
			swappedStr.append(charArray[i]);
			swappedStr.append(charArray[j]);
		}
		else
		{
			swappedStr.append(charArray[j]);
			swappedStr.append(charArray[i]);
		}
		
		return swappedStr.toString();
	}
	
	/* Method 2:
	 static String swapEmptySpace(String str)
	{
		StringBuilder result = new StringBuilder();
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == 'R' && str.charAt(i+1) == '_')
			{
				result.append("_");
				result.append("R");
			}
			else if(str.charAt(i) == 'L' && str.charAt(i-1) == '_')
			{
				result.append("L");
				result.append("_");
			}
			else if(str.charAt(i) != '_')
				result.append(str.charAt(i));
		}
		return result.toString();
    }
	 */

	
	public static void main(String[] args)
	{
		String str = "R__LR_R_L";
		System.out.println(swapEmptySpace(str));
	}
}
