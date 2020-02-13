package Google_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 * There are several words in a file. Get the occurrence of every word and sort it based on the occurrence,
 * if more than one word is having same occurrence than sort it alphabetically.
 */
public class WordOccuranceFile 
{
	static void wordOccurance(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		LinkedHashMap<String, Integer> hmap = new LinkedHashMap<>();
		
		String line = null;
		String text = "";
		
		//Parsing a file line by line and append it in a String
		while((line = br.readLine()) != null) {	
			text = text.concat(line);			
		}
		
		for(String items : text.split("[\\s,;.]+")) {
			hmap.merge(items, 1, Integer::sum);
		}
		
		System.out.println(hmap);
		
		String[] words = new String[hmap.size()];
		int index=0;
		
		for(String word: hmap.keySet()) {
			words[index++] = word;
		}
		
		//Sort with Comparator
		Arrays.sort(words, (s1,s2)-> {
        	int fs1 = hmap.get(s1);
        	int fs2 = hmap.get(s2);
        	
        	if(fs1 > fs2)
        		return -1;			//s1 comes before s2 [s1,s2]
        	if(fs1 < fs2)
        		return 1;			//s1 comes after s2 [s2,s1]
        	
        	return (s1.toLowerCase().compareTo(s2.toLowerCase()) > 0)? 1:-1;	//it sorts words in ascending order by ignoring case
        });
		
		System.out.println(Arrays.toString(words));
	}
	
	public static void main(String[] args) throws IOException
	{
		String path = "C:\\Users\\kdesai\\Downloads\\SampleTextFile.txt";
		WordOccuranceFile.wordOccurance(path);
	}
}
