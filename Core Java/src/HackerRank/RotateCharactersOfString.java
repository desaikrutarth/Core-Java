package HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters.
If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet.
In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

1) Input: String = middle-Outz, k = 2
Output: okffng-Qwvb

Explanation:

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b

2) Input: String = www.abc.xy, k = 87
   Output: fff.jkl.gh
 */
public class RotateCharactersOfString
{
	static String caesarCipher(String str, int k)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index=0;
        for(int i=0; i<k; i++)
        {
        	if(index == alphabet.length())
        		index=0;
        	index++;
        }
        String rotated = alphabet.substring(index)+alphabet.substring(0,index);
        
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<alphabet.length(); i++)
            map.put(alphabet.charAt(i),rotated.charAt(i));
        
        StringBuilder result = new StringBuilder();
        for(char ch : str.toCharArray())
        {
            if(Character.isLetter(ch))
            {
                if(Character.isLowerCase(ch))
                    result.append(map.get(ch));
                else
                {
                    char val = map.get(Character.toLowerCase(ch));
                    result.append(Character.toUpperCase(val));
                }
            }
            else
                result.append(ch);
        }
        return result.toString();
    }

    static boolean isValid(String str)
    {
        for(int i=1; i<str.length(); i++)
        {
            if(str.charAt(i) == str.charAt(i-1))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args)
    {
    	System.out.println(caesarCipher("www.abc.xy",87));
	}

}
