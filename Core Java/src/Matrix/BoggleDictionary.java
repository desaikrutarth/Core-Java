package Matrix;
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
public class BoggleDictionary 
{
/*	static final int SIZE = 26;
    
    static final int M = 3;
    static final int N = 3;
      
    // trie Node
    static class TrieNode
    {
        TrieNode[] Child = new TrieNode[SIZE];
      
        // isLeaf is true if the node represents
        // end of a word
        boolean leaf;
         
        //constructor
        public TrieNode() {
            leaf = false;
            for (int i =0 ; i< SIZE ; i++)
               Child[i] = null;
        }
    }
    
 // If not present, inserts a key into the trie
    // If the key is a prefix of trie node, just
    // marks leaf node
    static void insert(TrieNode root, String Key)
    {
        int n = Key.length();
        TrieNode pChild = root;
      
        for (int i=0; i<n; i++)
        {
            int index = Key.charAt(i) - 'A';
      
            if (pChild.Child[index] == null)
                pChild.Child[index] = new TrieNode();
      
            pChild = pChild.Child[index];
        }
      
        // make last node as leaf node
        pChild.leaf = true;
    }
    
    static boolean isSafe(int i, int j, boolean visited[][])
    {
        return (i >=0 && i < M && j >=0 &&
                j < N && !visited[i][j]);
    }
      
    // A recursive function to print all words present on boggle
    static void searchWord(TrieNode root, char boggle[][], int i, int j, boolean visited[][], String str)
    {
        // if we found word in trie / dictionary
        if (root.leaf == true)
           System.out.println(str);
         
        // If both I and j in  range and we visited
        // that element of matrix first time
        if (isSafe(i, j, visited))
        {
            // make it visited
            visited[i][j] = true;
      
            // traverse all child of current root
            for (int K =0; K < SIZE; K++)
            {
                if (root.Child[K] != null)
                {
                    // current character
                    char ch = (char) (K + 'A') ;
      
                    // Recursively search reaming character of word
                    // in trie for all 8 adjacent cells of 
                    // boggle[i][j]
                    if (isSafe(i+1,j+1,visited) && boggle[i+1][j+1]
                                                           == ch)
                        searchWord(root.Child[K],boggle,i+1,j+1,
                                                   visited,str+ch);
                    if (isSafe(i, j+1,visited)  && boggle[i][j+1]
                                                           == ch)
                        searchWord(root.Child[K],boggle,i, j+1,
                                                  visited,str+ch);
                    if (isSafe(i-1,j+1,visited) && boggle[i-1][j+1] 
                                                           == ch)
                        searchWord(root.Child[K],boggle,i-1, j+1,
                                                  visited,str+ch);
                    if (isSafe(i+1,j, visited)  && boggle[i+1][j] 
                                                          == ch)
                        searchWord(root.Child[K],boggle,i+1, j,
                                                 visited,str+ch);
                    if (isSafe(i+1,j-1,visited) && boggle[i+1][j-1] 
                                                          == ch)
                        searchWord(root.Child[K],boggle,i+1, j-1,
                                                  visited,str+ch);
                    if (isSafe(i, j-1,visited)&& boggle[i][j-1] 
                                                         == ch)
                        searchWord(root.Child[K],boggle,i,j-1,
                                                 visited,str+ch);
                    if (isSafe(i-1,j-1,visited) && boggle[i-1][j-1] 
                                                         == ch)
                        searchWord(root.Child[K],boggle,i-1, j-1,
                                                visited,str+ch);
                    if (isSafe(i-1, j,visited) && boggle[i-1][j] 
                                                        == ch)
                        searchWord(root.Child[K],boggle,i-1, j, 
                                              visited,str+ch);
                }
            }
      
            // make current element unvisited
            visited[i][j] = false;
        }
    }
    
 // Prints all words present in dictionary.
    static void findWords(char boggle[][], TrieNode root)
    {
        // Mark all characters as not visited
        boolean[][] visited = new boolean[M][N];
        TrieNode pChild = root ;
      
        String str = "";
      
        // traverse all matrix elements
        for (int i = 0 ; i < M; i++)
        {
            for (int j = 0 ; j < N ; j++)
            {
                // we start searching for word in dictionary
                // if we found a character which is child
                // of Trie root
                if (pChild.Child[(boggle[i][j]) - 'A'] != null)
                {
                    str = str+boggle[i][j];
                    searchWord(pChild.Child[(boggle[i][j]) - 'A'],
                               boggle, i, j, visited, str);
                    str = "";
                }
            }
        }
    }
*/	
	public static void findWords(char[][] boggle, String[] dictionary)
	{
		boolean result = false;
		for(String word : dictionary)
		{
			for(int i=0; i<boggle.length; i++)
			{
				for(int j=0; j<boggle[0].length; j++)
				{
					result = isValid(boggle, word, i, j, 0);
					if(result)
					{
						System.out.println(word);
						break;
					}
				}
				if(result)
					break;
			}
		}
	}
	
	public static boolean isValid(char[][] boggle, String word, int rowIndex, int colIndex, int wordIndex)
	{
		if(rowIndex >= boggle.length || colIndex >= boggle[0].length || rowIndex < 0 || colIndex < 0)
			return false;
		
		if(boggle[rowIndex][colIndex] != word.charAt(wordIndex) || boggle[rowIndex][colIndex] == '*')
			return false;
		
		boggle[rowIndex][colIndex] = '*'; 		//Mark as a visited
		
		if(wordIndex == word.length()-1)
			return true;
		
		boolean result = isValid(boggle, word, rowIndex+1, colIndex+1, wordIndex+1) ||	//down-right
						 isValid(boggle, word, rowIndex-1, colIndex, wordIndex+1)   ||	//up
						 isValid(boggle, word, rowIndex+1, colIndex-1, wordIndex+1) ||	//down-left
						 isValid(boggle, word, rowIndex, colIndex+1, wordIndex+1)   ||	//right
						 isValid(boggle, word, rowIndex, colIndex-1, wordIndex+1)   ||	//left
						 isValid(boggle, word, rowIndex+1, colIndex, wordIndex+1)   ||	//down
						 isValid(boggle, word, rowIndex-1, colIndex-1, wordIndex+1) ||	//up-left
						 isValid(boggle, word, rowIndex-1, colIndex+1, wordIndex+1);	//up-right
		//Backtrack
		boggle[rowIndex][colIndex] = word.charAt(wordIndex);
		return result;
	}
    
    public static void main(String args[])
    {
        // Let the given dictionary be following
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE", "GSE"};
      
        // root Node of trie
//        TrieNode root = new TrieNode();
//      
//        // insert all words of dictionary into trie
//        int n = dictionary.length;
//        for (int i=0; i<n; i++)
//            insert(root, dictionary[i]);
      
        char boggle[][] = {{'G','I','Z'},
                           {'U','E','K'},
                           {'Q','S','E'}
        };
      
        findWords(boggle,dictionary);         
    }
}
