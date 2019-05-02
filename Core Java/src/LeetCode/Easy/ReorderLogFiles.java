package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class ReorderLogFiles
{
	/*public static String[] reorderLogFiles(String[] logs)
	{
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2)
            {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                	return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }*/
	
	public static String[] reorderLogFiles(String[] logs)
	{
        List<String> digitLogs = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        String[] output = new String[logs.length];
        int index=0;
       
        for(String log : logs)
        {
        	String[] strArray = log.split(" ", 2);
        	if(Character.isDigit(strArray[1].charAt(0)))			//check if String is digit
        		digitLogs.add(log);
        	else
        		map.put(strArray[0], strArray[1]);
        }
        
        map = map.entrySet()		//sort map by value 
                 .stream()
                 .sorted(comparingByValue())
                . collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        
        for(String key : map.keySet())
        	output[index++] = key + " " + map.get(key);
        
        for(String digit : digitLogs)
        	output[index++] = digit;
        
        return output;
    }


	public static void main(String[] args)
	{
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		System.out.println(Arrays.toString(reorderLogFiles(logs)));
	}
}