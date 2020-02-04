package DFS_BFS;

import java.util.Stack;

public class DFS 
{
	private Stack<Vertex> stack = new Stack<>();
		
	public void dfs(Vertex root)
	{
		stack.push(root);
		root.setVisited(true);
		
		while(!stack.isEmpty())
		{
			Vertex actualVertex = stack.pop();
			System.out.print(actualVertex + " ");
			
			for(Vertex v : actualVertex.getAdjacenciesList())
			{
				if(!v.isVisited())
				{
					v.setVisited(true);
				//	v.setPredecessors(actualVertex);
					stack.push(v);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		
		A.addNeighbour(B);
		A.addNeighbour(C);
		B.addNeighbour(D);
		B.addNeighbour(E);
		
		DFS d = new DFS();
		System.out.print("DFS: ");
		d.dfs(A);
	}
}
