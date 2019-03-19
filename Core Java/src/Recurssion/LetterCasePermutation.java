package Recurssion;

import java.util.ArrayList;
import java.util.List;
/*
 Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */
public class LetterCasePermutation 
{
	 public static List<String> letterCasePermutation(String S)
	 {
		 List<String> ans = new ArrayList<>();
		 backtrack(ans, 0, S.toCharArray());
		 return ans;
	 }
	    
	 public static void backtrack(List<String> ans, int i, char[] S)
	 {
		 if(i==S.length)
			 ans.add(new String(S));
		 else
		 {
			 if(Character.isLetter(S[i])) 			//If it's letter
			 { 
				 S[i] = Character.toUpperCase(S[i]);
				 backtrack(ans, i+1, S); 			//Upper case branch
				 
				 S[i] = Character.toLowerCase(S[i]);
				 backtrack(ans, i+1, S); 			//Lower case branch
			 }
			 else
				 backtrack(ans, i+1, S); 
		 }
	 }
	 
	 public static void main(String[] args) 
	 {
		 System.out.println(letterCasePermutation("a1b2"));
	 }
}
