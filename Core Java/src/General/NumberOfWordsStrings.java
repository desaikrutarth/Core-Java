package General;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
For a given string and dictionary, how many sentences can you make from the string, such that all the words are contained in the dictionary. 

eg: for given string -> "appletablet" 
"apple", "tablet" 
"applet", "able", "t" 
"apple", "table", "t" 
"app", "let", "able", "t" 

"applet", {app, let, apple, t, applet} => 5 
"thing", {"thing"} -> 1
*/
public class NumberOfWordsStrings
{
	/*public static int findValidStrings(String str, Set<String> dictionary)
	{       
        final Set<String> validWords = new HashSet<String>(); 
        for (int i = 0; i < str.length(); i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length(); j++)
            {
                sb.append(str.charAt(j)); // O(1) complexity.
                if (dictionary.contains(sb.toString())) {
                    validWords.add(sb.toString());
                }
            }
        }
        System.out.println(validWords);
        return validWords.size();
    }*/
	
	public static int findValidStrings(String input, Set<String> dictionary)
	{       
        final Set<String> validWords = new HashSet<String>(); 
        for(String str : dictionary)
        {
        	if(input.contains(str))
        		validWords.add(str);
        }
        System.out.println(validWords);
        return validWords.size();
    }

	public static void main(String[] args) 
	{
		String str = "applet";
		Set<String> dictionary = new HashSet<>(Arrays.asList("app", "let", "apple", "t", "applet"));
		System.out.println(findValidStrings(str, dictionary));
	}
}
