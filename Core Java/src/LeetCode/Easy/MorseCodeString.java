
package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*
 International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2

Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
 */
public class MorseCodeString
{
	public static int uniqueMorseRepresentations(String[] words)
	{
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet<>();
        for (String word: words)
        {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }
	
	/*public static int uniqueMorseRepresentations(String[] words)
	{
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        
        HashMap<Character, String> map = new HashMap<>();
        
        for(int i=0; i<MORSE.length; i++)
        {
        	char alpha = (char)('a'+ i);
        	String morseCode = MORSE[i];
        	
        	map.put(alpha, morseCode);
        }
        
        Set<String> set = new HashSet<>();
        for(String word : words)
        {
        	String morse = "";
        	for(char ch : word.toCharArray())
        	{
        		morse += map.get(ch);
        	}
        	set.add(morse);
        }
        return set.size();
	}*/
	
	public static void main(String[] args) 
	{
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}
}
