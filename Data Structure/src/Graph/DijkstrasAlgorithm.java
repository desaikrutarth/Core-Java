package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertexs implements Comparable<Vertexs>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertexs previous;
    
    public Vertexs(String argName) {
    	name = argName;
    }
    public String toString() { 
    	return name; 
    }
    
    public int compareTo(Vertexs other){
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge
{
    public final Vertexs target;
    public final double weight;
    
    public Edge(Vertexs argTarget, double argWeight)
    { 
    	target = argTarget; 
    	weight = argWeight; 
    }
}

public class DijkstrasAlgorithm 
{
	public static void computePaths(Vertexs vertex)
    {
        vertex.minDistance = 0.;
        PriorityQueue<Vertexs> VertexsQueue = new PriorityQueue<Vertexs>();
        VertexsQueue.add(vertex);

        while (!VertexsQueue.isEmpty()) {
            Vertexs topVertex = VertexsQueue.poll();

            // Visit each edge exiting u
            for (Edge edge : topVertex.adjacencies)
            {
                Vertexs targetVertex = edge.target;
                double weight = edge.weight;
                double distanceThroughU = topVertex.minDistance + weight;
                if (distanceThroughU < targetVertex.minDistance) {
                    VertexsQueue.remove(targetVertex);

                    targetVertex.minDistance = distanceThroughU ;
                    targetVertex.previous = topVertex;
                    VertexsQueue.add(targetVertex);
                }
            }
        }
    }

    public static List<Vertexs> getShortestPathTo(Vertexs target)
    {
        List<Vertexs> path = new ArrayList<Vertexs>();
        for (Vertexs Vertexs = target; Vertexs != null; Vertexs = Vertexs.previous)
            path.add(Vertexs);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        Vertexs A = new Vertexs("A");
        Vertexs B = new Vertexs("B");
        Vertexs D = new Vertexs("D");
        Vertexs F = new Vertexs("F");
        Vertexs K = new Vertexs("K");
        Vertexs J = new Vertexs("J");
        Vertexs M = new Vertexs("M");
        Vertexs O = new Vertexs("O");
        Vertexs P = new Vertexs("P");
        Vertexs R = new Vertexs("R");
        Vertexs Z = new Vertexs("Z");

        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(M, 8) };
        B.adjacencies = new Edge[]{ new Edge(D, 11) };
        D.adjacencies = new Edge[]{ new Edge(B, 11) };
        F.adjacencies = new Edge[]{ new Edge(K, 23) };
        K.adjacencies = new Edge[]{ new Edge(O, 40) };
        J.adjacencies = new Edge[]{ new Edge(K, 25) };
        M.adjacencies = new Edge[]{ new Edge(R, 8) };
        O.adjacencies = new Edge[]{ new Edge(K, 40) }; 
        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
        R.adjacencies = new Edge[]{ new Edge(P, 15) };
        Z.adjacencies = new Edge[]{ new Edge(P, 18) };


        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<Vertexs> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);

    }
}
