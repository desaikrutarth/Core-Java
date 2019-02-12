package programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;

//In a file there are 1 million words . Find 10 most frequent words in that file in java

class Program
{
	void method(String path) throws FileNotFoundException
	{
		try
		{
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			BufferedReader br = new BufferedReader(new FileReader(path));
		    String line = null;
		    
		    String text = "";
		    while ((line = br.readLine()) != null)
		    {		    	
		    	text = text.concat(line);
		    }

		    String[] word = text.split(" ");
		    for(int i=0; i < word.length; i++)
	    	{
	    		if(hmap.containsKey(word[i]))
		    	{
		    		int val = hmap.get(word[i]);
		    		val++;
		    		hmap.put(word[i], val);
		    	}
		    	else
		    		hmap.put(word[i], 1);
	    	}
		    
		    //sort HashMap by value in descending order
		    Map<String, Integer> sortedDesc = hmap.entrySet()		            
		            							  .stream()
		            							  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		            							  .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
		    
		    System.out.println(sortedDesc);
		    
		   /* List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(hmap.entrySet());
		    Comparator<Entry<String, Integer>> byMapValues = new Comparator<Entry<String, Integer>>(){
		    	@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {					
					return o1.getValue().compareTo(o2.getValue());
				}
		    };
		    Collections.sort(list, byMapValues);
		    
		    int cnt = 0;
		    for(Entry<String, Integer> items : list)
		    {
		    	System.out.println(items);
		    	cnt++;
		    	
		    	if(cnt == 10)
		    		break;
		    }*/
		    
//			Set<Entry<Character, Integer>> entrySet = hmap.entrySet();				
			/*	for(int i = 0; i < input.length(); i++)
				{	
					for(Entry<Character,Integer> entry : hmap.entrySet())
					{
						int num = Character.getNumericValue(input.charAt(i));
						if(num == entry.getValue())
						{
							System.out.println(entry.getKey()+" = "+entry.getValue());
						}
					}
				}
				*/
		    
		  /*  String mostRepeatedWord = null;
			
			int count = 0;
			
			Set<Entry<String, Integer>> entrySet = hmap.entrySet();
			
			for (Entry<String, Integer> entry : entrySet)
			{
				if(entry.getValue() > count)
				{
					mostRepeatedWord = entry.getKey();
					
					count = entry.getValue();
				}
			}
			
			System.out.println("The most repeated word in input file is : "+mostRepeatedWord);
			
			System.out.println("Number Of Occurrences : "+count); */
		   
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

public class TenMaxWordCountFile 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Program p = new Program();
		String path = "C:\\Users\\Krutarth\\Downloads\\SampleTextFile.txt";
		p.method(path);
	}
}
