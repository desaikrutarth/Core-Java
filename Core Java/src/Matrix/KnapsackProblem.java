package Matrix;

public class KnapsackProblem 
{
	int numOfItems;
	int capacityOfKnapsack;
	int[][] knapsackTable;
	int totalBenefit;
	int[] weights;
	int[] values;
	
	public KnapsackProblem(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values)
	{
		this.numOfItems = numOfItems;
		this. capacityOfKnapsack = capacityOfKnapsack;
		this.weights = weights;
		this.values = values;
		this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
	}
	
	void knapsack()
	{
		//first row and first column is filled by 0s. so start with 1
		for(int i=1; i<numOfItems+1; i++)
		{
			for(int w=1; w<capacityOfKnapsack+1; w++)
			{
				int notTakingItem = knapsackTable[i-1][w];		//Not taking items 
				int takingItem = 0;
				
				if(weights[i] <= w)
					takingItem = values[i] + knapsackTable[i-1][w-weights[i]];
				knapsackTable[i][w] = Math.max(notTakingItem, takingItem);		//S[i][w] = Max(S[i-1][w], Vi + S[i-1][W-Wi])
			}
		}
		totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];     //last cell of table which is intersection of last row and last column
	}
	
	void print()
	{
		System.out.println("Total benefit: "+totalBenefit);
		int w = capacityOfKnapsack;
		
		for(int n=numOfItems; n > 0; n--)
		{
			if(knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w])
			{
				System.out.println("We take items: "+n);
				w = w - weights[n];
			}
		}
	}
	
	public static void main(String[] args)
	{
		int numofItems = 3;
		int capacityOfKnapsack = 5;
		
		int[] weightOfItems = new int[numofItems + 1];
		weightOfItems[1] = 4;
		weightOfItems[2] = 2;
		weightOfItems[3] = 3;
		
		int[] profitOfItems = new int[numofItems + 1];
		profitOfItems[1] = 10;
		profitOfItems[2] = 4;
		profitOfItems[3] = 7;
		
		KnapsackProblem knap = new KnapsackProblem(numofItems, capacityOfKnapsack, weightOfItems, profitOfItems);
		knap.knapsack();
		knap.print();
	}
}
