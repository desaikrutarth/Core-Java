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
 * 		 0-----1
 * 		 |\	  /|\
 * 		 |  2  | 5	
 * 		 |/	  \|/	
 * 		 3-----4
 */
public class Practice
{	
	private static void coloringProblemGraph(int[][] matrix, int numOfColors) 
	{
		int noOfVertex = matrix.length;
		int[] colors = new int[matrix.length];
		
		if(solveProblem(matrix,numOfColors,noOfVertex,colors,0))
		{
			for(int i=0; i<noOfVertex; i++)
				System.out.println("Node "+(i+1)+" has color index: "+colors[i]);
		}
	}
	
	
	private static boolean solveProblem(int[][] matrix, int numOfColors, int noOfVertex, int[] colors, int nodeIndex) 
	{
		if(nodeIndex == noOfVertex)
			return true;
		
		for(int colorIndex = 1; colorIndex <= numOfColors; colorIndex++)
		{
			if(isValidColor(matrix,colors,nodeIndex,colorIndex))
			{
				colors[nodeIndex] = colorIndex;
				if(solveProblem(matrix, numOfColors, noOfVertex, colors, nodeIndex+1))
					return true;
			}
		}
		return false;
	}


	private static boolean isValidColor(int[][] matrix, int[] colors, int nodeIndex, int colorIndex)
	{
		for(int i=0; i<colors.length; i++)
		{
			if(matrix[nodeIndex][i] == 1 && colors[i] == colorIndex)
				return false;
		}
		return true;
	}


	public static void main(String[] args)
	{
		int[][] matrix = {{0,1,1,1,0,0},
		  		  		  {1,0,1,0,1,0},
		  		  		  {1,1,1,1,0,1},
		  		  		  {1,0,1,0,0,1},
		  		  		  {0,1,0,0,0,1},
		  		  		  {0,1,1,1,1,1}};

		int numOfColors = 4;

		coloringProblemGraph(matrix, numOfColors);
	}

	
	
} 


