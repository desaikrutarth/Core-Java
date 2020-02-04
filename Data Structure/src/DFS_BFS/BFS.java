package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{
	Queue<Vertex> queue = new LinkedList<>();
	
	public void bfs(Vertex root)
	{	
		queue.add(root);
		root.setVisited(true);
		
		while(!queue.isEmpty())
		{
			Vertex actualVertex = queue.remove();
			System.out.print(" "+actualVertex);
			
			for(Vertex v : actualVertex.getAdjacenciesList())
			{
				if(!v.isVisited())
				{
					v.setVisited(true);
					queue.add(v);
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
		
		BFS b = new BFS();
		System.out.print("BFS: ");
		b.bfs(A);
	}
}
