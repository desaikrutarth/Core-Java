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
		
		for(String items : text.split("[\\W]+")) {	// "\\W" splits the string from all special characters
			hmap.merge(items, 1, Integer::sum);
		}
		
		System.out.println(hmap);
		List<String> keyList = new ArrayList<String>(hmap.keySet());
		
		//Sort list with Comparator
		Collections.sort(keyList, (s1,s2)-> {
        	int fs1 = hmap.get(s1);
        	int fs2 = hmap.get(s2);
        	
        	if(fs1 > fs2)
        		return -1;			//s1 comes before s2 [s1,s2]
        	if(fs1 < fs2)
        		return 1;			//s1 comes after s2 [s2,s1]
        	
        	return (s1.toLowerCase().compareTo(s2.toLowerCase()) > 0)? 1:-1;	//it sorts words in ascending order by ignoring case
        });
		
		System.out.println(keyList);
	}
	
	public static void main(String[] args) throws IOException
	{
		String path = "C:\\Users\\kruta\\Downloads\\SampleTextFile.txt";
		WordOccuranceFile.wordOccurance(path);
	}
}
