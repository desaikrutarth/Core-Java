package Matrix;

import java.util.HashSet;
import java.util.Set;

public class CrosswordPuzzle
{
	static Set<String> resultSet = new HashSet<>();
	private static void findWords(char[][] crossword, String[] dictionary) 
	{
		findWordHelper(crossword,dictionary,0,0);
		System.out.println(resultSet);
	}
	
	private static void findWordHelper(char[][] crossword, String[] dictionary, int rowIndex, int colIndex)
	{
		if(rowIndex == crossword.length && ++colIndex == crossword.length) {
			return;
		}
		
		if(rowIndex == crossword.length)
			rowIndex=0;
		
		for(String word : dictionary)
		{
			doesWordExist(crossword,word,rowIndex,colIndex);
			findWordHelper(crossword, dictionary, rowIndex+1, colIndex);
		}
	}

	private static void doesWordExist(char[][] crossword, String word, int rowIndex, int colIndex)
	{
		String result = "";
		for(int i=0; i<crossword.length; i++)
		{
			result += crossword[i][colIndex];
			if(result.equals(word)) {
				resultSet.add(word);
			}
		}
		result = "";
		for(int j=0; j<crossword.length; j++)
		{
			result += crossword[rowIndex][j];
			if(result.equals(word)) {
				resultSet.add(word);
			}
		}
		
		result="";
		for(int i=rowIndex, j=colIndex; i<crossword.length && j<crossword.length; i++,j++)
		{
			result += crossword[i][j];
			if(result.equals(word)) {
				resultSet.add(word);
			}
		}
		
		result="";
		for(int i=rowIndex, j=colIndex; i<crossword.length && j>=0; i++,j--)
		{
			result += crossword[i][j];
			if(result.equals(word)) {
				resultSet.add(word);
			}
		}
	}

	public static void main(String[] args)
	{
		String dictionary[] = {"GAC","DOG","GOD","DAD","DAO"};
       
        char crossword[][] = {{'D','O','G'},
                           	  {'U','A','O'},
                           	  {'C','P','D'}};
        findWords(crossword, dictionary);
	}
}
