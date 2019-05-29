package Google_3;
/*
In school a student gets rewarded if he has an attendance record without being absent for more than once or being late for 3 times continuously. 
Given a student's attendance record represented by a string with 3 possible characters 'L'(Late), 'A'(Absent), 'O' (On time), 
check whether the student qualifies for the reward. 

e.g. 
@INPUT (String) "OLLAOOOLLO" 
@RETURN (Boolean) False 
The student does not qualify for reward because "LLA" means he was late for 3 times in a row. 

@INPUT (String) "OLLOAOLLO" 
@RETURN (Boolean) True 

Follow-up: 
If known the length of the attendance string is n, how many possible ways there is to attend school and make sure you get the reward.
 */
public class CheckStudentReward 
{
	public static boolean ShouldbeRewarded(String attendance)
	{

		int lateCount = 0;
		boolean isAbsent = false;
		
		for(int i=0; i<attendance.length(); i++)
		{
			char ch = attendance.charAt(i);
			if(ch == 'L')
			{
				lateCount++;
				if(lateCount == 3)
					return false;
			}
			else if(ch == 'A')
			{
				lateCount++;
				if(lateCount == 3 || isAbsent)
					return false;
				isAbsent = true;
			}
			else
				lateCount = 0;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String s = "OLLOAOLLO";
	//	String s = "OLLAOOOLLO";
		System.out.println(ShouldbeRewarded(s));
	}
}
