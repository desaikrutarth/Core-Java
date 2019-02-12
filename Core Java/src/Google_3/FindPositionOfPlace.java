package Google_3;
import java.util.Arrays;
/*
We have N gas stations, and we are given all the distances between each pair of station. So we have nC2 distances provided to us.
For example if I have 3 stations namely A, B, C the distances provided will be AB, AC, BC. We have to find the exact position of each gas station provided with these nC2 distances. 

eg. we have 5 stations so 5C2 distances are given in random order - 10, 20, 70, 80, 30, 20, 100, 70, 50, 90 

Output the exact positions of gas stations A, B, C, D, E 
i.e 
A - 0 
B - 10 
C - 30 
D - 80 
E - 100
https://drive.google.com/open?id=0BxPkptdH01OBZzEwX29iRGI4cEU 
 */
public class FindPositionOfPlace 
{
	public static int[] actualDistance(int n, int[] allPairDist)
	{
        if(allPairDist.length<=1)
            return allPairDist;
        
        int init=0;
        int result[]=new int[n];
        result[0]=init;
        Arrays.sort(allPairDist);
        int prev=allPairDist[0];
        if(n>1)
            result[1]=allPairDist[0];
        
        result[result.length-1]=allPairDist[allPairDist.length-1];
        int gs_num=2;   // next gs after result[1]
        removeDuplicates(allPairDist);
        for(int i=0;i<allPairDist.length;++i)
        {
            if(gs_num==n-1)
                break;
            if(allPairDist[i]==-1)
                break;
            if(i%2==1){
                result[gs_num++] = allPairDist[i] + prev;
            }else{
                prev=allPairDist[i];
            }
        }
        return result;
    }
	
	public static void removeDuplicates(int[] dist)
	{
	    int unq_cnt=0;
	    for(int i=1;i<dist.length;++i)
	    {
	        if(dist[unq_cnt]!=dist[i]){
	            dist[++unq_cnt]=dist[i];
	        }
	    }
	    for(int i=unq_cnt+1;i<dist.length;++i){
	        dist[i]=-1;
	    }
	    for(int i : dist){
	        System.out.print(i+" ");
	    }
	    System.out.println();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
        int[] dist=new int[]{10,20,70,80,30,20,100,70,50,90}; // Random distances
        // If you want you can also check if size is equal to 5c2
	    int result[] = actualDistance(5,dist);

	    for(int i : result){
	        System.out.println(i+" ");
	    }
	}
}
