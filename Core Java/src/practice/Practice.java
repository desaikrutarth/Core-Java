package practice;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import Backtracking.ColoringProblemGraph;
import Backtracking.MazeProblem;
import Backtracking.Sudoku;
import Google_1.LargestWordDictionary;
import Google_1.LongestAbsolutePath;
import Google_1.LongestSubstring;
import Google_1.MakeStringsAnagram;
import Google_1.MissingSequence;
import Google_1.StringComparison;
import Google_1.SubArrayOfSum;
import Google_2.ArrayPatternDetect;
import Google_2.MaxSumSubsequence;
import Google_2.MistakenNumber;
import programs.LengthOfString;
/*
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class Practice
{	
	public static int strStr(String haystack, String needle)
    {
        if(!haystack.contains(needle) || needle == "")
            return -1;
        
        for(int i=0; i<haystack.length(); i++)
        {
            if(haystack.charAt(i) == needle.charAt(0))
            {
                String substring = haystack.substring(i,i+needle.length());
                if(substring.equals(needle))
                    return i;
            }
        }
        return -1;
    }
	
	public static void main(String[] args)
	{
		System.out.println(strStr("hell", "ll"));

	}

	

} 


