package Google_3;

import java.util.Random;

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
				if(prev == curr)
				{
					while(prev == curr && curr % 2 == 0)
					{
						curr = (int) (Math.random()*10);
					}
				}
			}
			rand += curr;
			prev = curr;
		}
		return Integer.parseInt(rand);
	}
	
//	private static int getNumber()
//	{
//		int rand = (int) (Math.random()*10);
//		StringBuilder result = new StringBuilder().append(rand);
//		
//		for(int i=0; i<3; i++)
//		{
//			int num = (int) (Math.random()*10);
//			
//			while(num == rand)
//			{
//				num = (int) (Math.random()*10);
//			}
//			if(i == 2)
//			{
//				while(num % 2 != 0)
//				{
//					num = (int) (Math.random()*10);
//				}
//				if(num == rand)
//				{
//					while(num == rand && num % 2 == 0)
//					{
//						num = (int) (Math.random()*10);
//					}
//				}
//				
//			}
//			result.append(num);
//			rand = num;
//		}
//		return Integer.parseInt(result.toString());
//	}
    
    public static void main(String[] args)
    {
    	System.out.println(getNumber()); 	
    }
    
    
}
