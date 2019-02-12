package Recurssion;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Find how many numbers of length n are there such that each number is at least 4 smaller/greater than the number before and after it. 
	Eg: if n = 5, such numbers are 15951,26151,39518 etc.
 */
public class NumberOfLengthN
{         
	
	int getAllNum (int n, int length) 
	{
		if (length == 1) {
			return 1;
		}
		int combination = 0;
		for (int i = 0; i <= (n-4); i ++) {
			combination += getAllNum(i, length-1);
		}
		for (int i = 9; i >= (n+4); i--) {
			combination += getAllNum(i, length-1);
		}
		return combination;
	}

	int generateDigit(int length)
	{
		int total = 0;

		for (int i = 1; i < 10; i ++) 
		{
			total += getAllNum(i, length);
		}

		return total;

	}
  /*  BigInteger solve(int n)
    {                                               
        if (n == 0) return BigInteger.ZERO;                                 
        BigInteger[] counts = new BigInteger[10];                           
        BigInteger[] next = new BigInteger[10];                             
        BigInteger[] temp;                                                  
        Arrays.fill (counts, BigInteger.ONE);                               
        counts[0] = BigInteger.ZERO;                                        

        for (int i = 1; i < n; i++) {                                       
            for (int nextDigit = 0; nextDigit < 10; nextDigit++) {          
                next[nextDigit] = BigInteger.ZERO;                          
                for (int digit = 0; digit < 10; digit++) {                  
                    if (Math.abs (digit - nextDigit) >= 4) {                
                        next[nextDigit] = next[nextDigit].add (counts[digit]);
                    }                                                       
                }                                                           
            }                                                               
            temp = counts;                                                  
            counts = next;                                                  
            next = temp;                                                    
        }                                                                   

        BigInteger sum = BigInteger.ZERO;                                   
        for (BigInteger i : counts) sum = sum.add  (i);                     
        return sum;                                                         
    }    */        
	
	public static void main (String[] a)
	{ 
		System.out.println("Enter length");
        Scanner in = new Scanner (System.in);                               
        //System.out.println (new NumberOfLengthN().solve(in.nextInt()));  
        System.out.println (new NumberOfLengthN().generateDigit(in.nextInt()));              

    }
}
