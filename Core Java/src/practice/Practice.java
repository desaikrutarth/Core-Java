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
 Example 1:
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:
Input: "/a/./b/../../c/"
Output: "/c"

Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */
public class Practice
{	
	public static boolean lemonadeChange(int[] bills)
	{
		int fiveCount = 0;
		int tenCount = 0;
		for(int i=0; i<bills.length; i++)
		{
			if(bills[i] == 5)
			{
				fiveCount++;
			}
			else if(bills[i] == 10)
			{
				if(fiveCount < 1)
					return false;
				tenCount++;
				fiveCount--;
			}
			else
			{
				if(fiveCount >= 3)
					fiveCount = fiveCount - 3;
				else if(tenCount >= 1 && fiveCount >= 1)
				{
					tenCount--;
					fiveCount--;
				}
				else
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		int[] bills = {5,5,5,10,20};
		System.out.println(lemonadeChange(bills));
	}
} 


