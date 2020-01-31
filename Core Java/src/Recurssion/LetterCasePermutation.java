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
		 List<String> list = new ArrayList<>();
		 backtrack(list, 0, S.toCharArray());
		 return list;
	 }
	    
	 private static void backtrack(List<String> list, int i, char[] charArray)
	 {
		 if(i == charArray.length)
		 {
			 list.add(new String(charArray));
			 return;
		 }
		 
		 if(Character.isLetter(charArray[i]))		// If it's letter
		 {
			 charArray[i] = Character.toUpperCase(charArray[i]);	// Convert to upper case
			 backtrack(list, i+1, charArray);
			 
			 charArray[i] = Character.toLowerCase(charArray[i]);	// Convert to lower case
			 backtrack(list, i+1, charArray);
		 }
		 else
			 backtrack(list, i+1, charArray);		// If it's digit
	 }

	 public static void main(String[] args) 
	 {
		 System.out.println(letterCasePermutation("a1b2"));
	 }
}
