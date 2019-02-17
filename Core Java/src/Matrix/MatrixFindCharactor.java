package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. 
 * Find all possible words that can be formed by a sequence of adjacent characters. 
 * Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 * 
 * Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};
      isWord(str): returns true if str is present in dictionary
                   else false.

Output:  Following words of the dictionary are present
         GEEKS
         QUIZ
 */
public class MatrixFindCharactor 
{
	//Method 1 : With Recursion
	/*private static void findWords(char[][] boggle, String[] dictionary)
	{
		String result = "";
		List<String> dictionaryList = new ArrayList<>(Arrays.asList(dictionary));
		for(String word : dictionary)
		{
			for(int i=0; i<word.length(); i++)
			{
				char ch = word.charAt(i);
				if(doesExist(boggle,ch,0,0))
					result += ch;
				else
					break;
			}
			if(dictionaryList.contains(result))
				System.out.println(result);
			result = "";
		}
	}
	
	private static boolean doesExist(char[][] boggle, char ch, int i, int j)
	{
		int rowIndex = boggle.length;
		int colIndex = boggle[0].length;
		
		if(i<0||i>=rowIndex||j<0||j>=colIndex)
			return false;
		
		if(boggle[i][j] == ch)
			return true;
		
		if(doesExist(boggle, ch, i+1, j)) return true;
		if(doesExist(boggle, ch, i+1, j+1)) return true;
		if(doesExist(boggle, ch, i, j+1)) return true;
		
		return false;
	}*/

	private static void findWords(char[][] boggle, String[] dictionary) 
	{
		int m = boggle.length, n = boggle[0].length;
		int[] set = new int[128];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				set[boggle[i][j]]++;
		}

		for (String s : dictionary) {
			int[] temSet = Arrays.copyOf(set, set.length);
			boolean flag = false;
			for (char c : s.toCharArray())
				if (--temSet[c] < 0) {
					flag = true;
					break;
				}
			if (!flag)
				System.out.println(s);

		}
	}
	public static void main(String args[])
    {
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};
      
        char boggle[][] = {{'G','I','Z'},
                           {'U','E','K'},
                           {'Q','S','E'}
        };
      
        findWords(boggle, dictionary);
              
    }

	


}
