package Matrix;

public class RodCuttingProblem 
{
	int[][] dpTable;
	int lengthOfRod;
	int[] prices;
	
	public RodCuttingProblem(int lengthOfRod, int[] prices)
	{
		this.prices = prices;
		this.lengthOfRod = lengthOfRod;
		this.dpTable = new int[prices.length+1][lengthOfRod+1];
	}
	
	public void rodCutting()
	{
		// First row and columns are 0s so start with j=1
		for(int i=1; i < prices.length; i++)
		{
			for(int j=1; j <= lengthOfRod; j++)
			{
				if(i <= j) 		//if rod length is greater than cut
					dpTable[i][j] = Math.max(dpTable[i-1][j], prices[i] + dpTable[i-1][j-i]);   //Max(Don't make a cut, Make a cut)
				else
					dpTable[i][j] = dpTable[i-1][j];		//Do not make a cut
			}
		}
	}
	
	public void print()
	{
		System.out.println("Max Profit: $"+dpTable[prices.length-1][lengthOfRod]);
		
		int w = lengthOfRod;
		for(int n = prices.length-1; n>0;)
		{
			if(dpTable[n][w] != 0 && dpTable[n][w] != dpTable[n-1][w])
			{
				System.out.println("cut = "+n+" meter");
				w = w-n;
			}
			else
				n--;
		}
	}
	
	public static void main(String[] args)
	{
		int lengthOfRod = 5;
		int[] prices = {0,2,5,7,3};
		
		RodCuttingProblem rod = new RodCuttingProblem(lengthOfRod, prices);
		rod.rodCutting();
		rod.print();
	}
}
