package Google_1;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a set of strings (denoting URLs), like: 

1. abc.pqr.google.com 
2. pqr.google.com 
3. pqr.google.net 
4. yahoo.com 
5. abc.yahoo.com 
etc... 

find an efficient way to find out how many times a particular string appears as a substring.
For e.g., given the above set of strings, "google.com" appears twice; ".com" appears four times, "pqr.google.com" appears twice, and so on. 

Follow up: How would you do this, if the input was no longer a URL (So, "abc.pqr.google.com" and "pqr.abc.google.com", both are valid)?
 */

class Trie {

	String word;
	List<Trie> next = new ArrayList<Trie>();
	int count;

	public Trie(String word) {
		this.word = word;
	}
}

public class SubstringsCounts 
{
	
	public static void display(Trie node, String str) 
	{

		if (node == null)
			return;
		if (node.next.isEmpty())
			return;

		List<Trie> next = node.next;
		for (Trie trie : next) {
			display(trie, str + "." +trie.word);
			System.out.println(str + "." +trie.word + " - " + trie.count);
		}
	}

	public static void add(Trie root, String str)
	{
		String[] arr = str.split("\\.");
		int k = 0;
		while (k < arr.length) 
		{
			Trie node = root;
			for (int i = k; i < arr.length; i++) 
			{
				Trie t = null;
				for (Trie tr : node.next)
				{
					if (tr.word.equals(arr[i])) 
					{
						t = tr;
						break;
					}
				}
				if (t == null) 
				{
					t = new Trie(arr[i]);
					node.next.add(t);
				}
				t.count += 1;
				node = t;
			}
			k++;
		}
	}

	public static void main(String[] args) 
	{
		Trie root = new Trie("");
		add(root, "abc.pqr.google.com");
		add(root, "pqr.google.com");
		add(root, "pqr.google.net");
		add(root, "yahoo.com");
		add(root, "abc.yahoo.com");

		display(root, "");
	}
}
