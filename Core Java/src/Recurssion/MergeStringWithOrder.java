package Recurssion;
/*
given 2 strings A and B. generate all possible solutions when B is merged in A. 
Ex: A = "hey" 
	B = "sam" 
then solutions are : 

heysam,hseaym,hesaym,sahemy etc. 

notice that order should be the same for both of strings while merging.
 */
public class MergeStringWithOrder
{
	public static void merge(String parent,String str1,String str2)
	{
        if (str1.equals(""))
        {
            System.out.println(parent+str2);
            return;
        } 
        else if (str2.equals("")) 
        {
            System.out.println(parent+str1);
            return;
        }

        merge(parent+str1.substring(0,1),str1.substring(1),str2);
        merge(parent+str2.substring(0,1),str1,str2.substring(1));
    }


    public static void main(String a[]){
        merge("","hey","sam");
    }
}
