package Google_3;
/*
 * Generate a random 4-digit even number : the adjacent 2 digits must be different. 
 */
public class GenerateRandom4DigitEven 
{
	private static int getNumber()
	{
		String rand = "";
		int prev = 0;
		int curr = 0;
		for(int i = 1; i<=4;i++)
		{
			while (prev==curr)
			{
				 curr = (int) (Math.random()*10);
			}
			
			if(i == 4)
			{
				while (curr%2 ==1)
				{
					curr = (int) (Math.random()*10);
				}
			}
			rand += curr;
			prev = curr;
		}
		return Integer.parseInt(rand);
	}
    
    public static void main(String[] args)
    {
    	System.out.println(getNumber()); 	
    }
}
