package HackerRank;

public class CommonChildDP
{
	static int commonChild(String s1, String s2)
	{
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		
		int dp[] = new int[Y.length + 1];

		for (int i = 1; i <= X.length; i++)
		{
			int prev = 0;
			for (int j = 1; j <= Y.length; j++)
			{
				int temp = dp[j];
				if (X[i - 1] == Y[j - 1])
					dp[j] = prev + 1;
				else
					dp[j] = Math.max(dp[j], dp[j - 1]);
				
				prev = temp;
			}

		}
		return dp[Y.length];
	}

	public static void main(String[] args)
	{
		System.out.println(commonChild("ABCD", "ABDC"));
	}

}
