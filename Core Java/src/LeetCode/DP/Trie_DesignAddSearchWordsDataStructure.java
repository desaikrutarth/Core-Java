package LeetCode.DP;

public class Trie_DesignAddSearchWordsDataStructure
{
	public class TrieNode 
	{
		public String item = "";
        public TrieNode[] children = new TrieNode[26];       
    }
    
    private TrieNode root = new TrieNode();

    public void addWord(String word) 
    {
        TrieNode node = root;
        for (char ch : word.toCharArray())
        {
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            
            node = node.children[ch - 'a'];
        }
        node.item = word;
        System.out.println(node.item);
    }

    public boolean search(String word)
    {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node)
    {
        if (k == chs.length) 
        	return !node.item.equals("");   
        if (chs[k] != '.')
            return node.children[chs[k] - 'a'] != null 
            		&& match(chs, k + 1, node.children[chs[k] - 'a']);
        else 
        {
            for (int i = 0; i < node.children.length; i++) 
            {
                if (node.children[i] != null) 
                {
                    if (match(chs, k + 1, node.children[i])) 
                        return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args)
    {
    	Trie_DesignAddSearchWordsDataStructure trie = new Trie_DesignAddSearchWordsDataStructure();
    	trie.addWord("bad");
    	trie.addWord("dad");
    	trie.addWord("mad");
    	System.out.println(trie.search("pad"));
    	System.out.println(trie.search("bad"));
    	System.out.println(trie.search(".ad"));
    	System.out.println(trie.search("b.."));
    	System.out.println(trie.search("b.d"));
    	System.out.println(trie.search("b..d"));
    	System.out.println(trie.search("m.d."));
    	trie.addWord("a");
    	System.out.println(trie.search("a."));
    	System.out.println(trie.search(".a"));
	}
}
