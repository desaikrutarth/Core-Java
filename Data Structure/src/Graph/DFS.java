package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex
{
	public char label; // label (e.g. ‘A’)
	public boolean wasVisited;
	public Vertex(char lab) // constructor
	{
		label = lab;
		wasVisited = false;
	}
}

class Graph
{
	public final int MAX_VERTS = 20;
	public Vertex vertexList[]; // array of vertices
	public int adjMat[][]; // adjacency matrix
	public int nVerts; // current number of vertices

	public Graph() // constructor
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];		 // adjacency matrix
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++) // set adjacency
			for(int k=0; k<MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
	} 

	public void addVertex(char lab) // argument is label
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	
	// Depth-first search
	Stack<Integer> theStack = new Stack<>();
	public void dfs() 
	{ 
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0); 
		theStack.push(0); 
		while( !theStack.isEmpty() ) 
		{
			int v = getAdjUnvisitedVertex( theStack.peek() );
			if(v == -1) 
				theStack.pop(); 
			else 
			{
				vertexList[v].wasVisited = true; // mark it
				displayVertex(v);
				theStack.push(v); 
			}
		} 

		for(int j=0; j<nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	}
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
				return j; // return first such vertex
		return -1; // no such vertices
	}
	
	// Breadth-first search	
	Queue<Integer> theQueue = new LinkedList<Integer>();
	public void bfs() // breadth-first search
	{ // begin at vertex 0
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0); 
		theQueue.add(0); 
		int v2;
		while( !theQueue.isEmpty() ) 
		{
			int v1 = theQueue.remove(); 
			while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
			{ 
				vertexList[v2].wasVisited = true; // mark it
				displayVertex(v2); 
				theQueue.add(v2);
			}
		} 

		for(int j=0; j<nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	} 
}

public class DFS 
{
	public static void main(String[] args)
	{
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(0, 2); // BC
		theGraph.addEdge(1, 3); // AD
		theGraph.addEdge(1, 4); // DE
		
		System.out.print("DFS: ");
		theGraph.dfs(); // depth-first search
		System.out.println();
		System.out.print("BFS: ");
		theGraph.bfs(); // Breadth-first search
	}
}
