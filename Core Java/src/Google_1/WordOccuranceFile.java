package Google_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
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
		
		while((line = br.readLine()) != null)
		{
			text = text.concat(line);
		}
		String[] word = text.split(" ");
		
		for(String items : word)
		{
			hmap.merge(items, 1, Integer::sum);
		}
		
		System.out.println(hmap);
		
		ArrayList<Integer> list = new ArrayList<>(hmap.values());
		Collections.sort(list, Collections.reverseOrder());
		
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
		for(int items : list)
		{
			for (String key : hmap.keySet()) 
			{
			      if (hmap.get(key).equals(items))
			      {
			    	  hm.put(key, items);
			      }
			}
		}
		System.out.println(hm);
	}
	
	public static void main(String[] args) throws IOException
	{
		String path = "C:\\Users\\Krutarth\\Downloads\\SampleTextFile.txt";
		WordOccuranceFile.wordOccurance(path);
	}
}
