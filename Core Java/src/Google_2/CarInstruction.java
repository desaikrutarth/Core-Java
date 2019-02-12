package Google_2;
/*
 * A car can receive two instructions A and R. 
 * A moves forward for a second and then doubles in speed. R stopped and then reversed.
 * Given a String composed of AR, find where will the car stop. 
Follow-up, given the location if the final stop, find the instruction string.
Example: AAAR
	Output: 2 (A->1,A->2,A->3,R->2)
 */
public class CarInstruction 
{
	static int goThroughString(String str)
	{
		int speed=0;
		int location = 0;
		
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='A')
			{
				if(speed==0)
					speed++;
				
				speed = speed * 2;
				location++;
			}
			else
			{
				speed=0;
				location--;
			}
		}
		return location;
	}
	
	public static void main(String[] args)
	{
	      System.out.println(goThroughString("AAAR"));
	}
}
