package LeetCode.Medium;

import java.util.List;
/*
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor.
For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root,
replace it with the root that has the shortest length.

Return the sentence after the replacement.

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"

Example 3:

Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
Output: "a a a a a a a a bbb baba a"

Example 4:

Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 5:

Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
Output: "it is ab that this solution is ac"
 */
public class ReplaceWordsDictionary
{
	public static String replaceWords(String[] dictionary, String sentence)
    {
        String[] sentences = sentence.split(" +");
        
        for(String word : dictionary)
        {
            for(int i=0; i<sentences.length; i++)
            {
                if(sentences[i].startsWith(word))
                {
                    sentences[i] = word;
                }           
            }
        }
        
        String result = "";
        for(int i=0; i<sentences.length; i++)
        {
            if(i==0)
                result += sentences[i];
            else
                result += " " + sentences[i];
        }
        return result;
    }
	
	public static void main(String[] args)
	{
		String[] dictionary = {"catt","cat","bat","rat"};
		String sentence = "the cattle was rattled by the battery";
		
		System.out.println(replaceWords(dictionary, sentence));
	}
}
