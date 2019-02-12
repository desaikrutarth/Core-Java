package Matrix;
/*
 * Assuming your budget is N, you need to buy a rectangular land. Give a matrix of land prices and ask what is the largest area available for buying land.
 * Land prices must be non-negative. For example, the budget is 11.

1 2 3 1
0 1 4 2
1 9 10 4

The output should be. 
1 2 3
0 1 4
Such a matrix, because 1 +2 +3 +0 +1 +4 = 11. And the largest area.
 */
public class FindLargestRectangleArea
{
	
	public static void maxArea(int ar[][],int limit){
		int costs[][] = new int[ar.length][ar[0].length];
 
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				int cost=0;
				if(i>0){
					cost = cost + costs[i-1][j];
				}
				if(j>0){
					cost= cost +costs[i][j-1];
				}
				if(i>0 && j >0){
					cost = cost-costs[i-1][j-1];
				}
				costs[i][j]=cost+ar[i][j];
			}
		}
	//	System.out.println(Arrays.deepToString(costs));
		int p=0,q=0,r=0,s=0;
		int maxArea = 0;
		for(int i=-1;i<ar.length;i++)
		{
			for(int j=-1;j<ar[0].length;j++)
			{
				for(int k=i+1;k<ar.length;k++)
				{
					for(int l=j+1;l<ar[0].length;l++)
					{
						int cost=costs[k][l];
						if(i > 0){
							cost = cost-costs[i][l];	
						}
						if(j > 0 ){
							cost = cost-costs[k][j];
						}
						if( i > 0 && j >0){
							cost = cost + costs[i][j];	
						}
						if(cost <= limit){
							int area = (k-i) * (l-j);
							if(maxArea < area){
								p=i;
								q=j;
								r=k;
								s=l;
								maxArea=area;
							}
						}
 
					}
				}
			}
		}
	//	System.out.println(p+" "+q+" "+r+" "+s);
		for(int i=p+1;i<=r;i++){
			for(int j=q+1;j<=s;j++){
				System.out.print(ar[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int ar[][] = {	{1,2,3,1},
						{0,1,4,2},
						{1,9,10,4}
					};
					maxArea(ar,11);
	}
}
