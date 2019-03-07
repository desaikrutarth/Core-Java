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
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class Practice
{	
	private static String  longestCommonPrefix(String[] arr)
	{	
		String prefix = arr[0];
		
		for(int i=1; i<arr.length; i++)
		{
			String word = arr[i];
			while(!word.startsWith(prefix))
				prefix = prefix.substring(0, prefix.length()-1);
		}
		return prefix;
	}
	
	public static void main(String[] args)
	{
		String[] arr = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(arr));
	}
} 


