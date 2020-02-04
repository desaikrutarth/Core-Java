package DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex 
{
	private String name;
	private boolean visited;
	private List<Vertex> adjacenciesList;
	private Vertex predecessors;
	
	public Vertex (String name)
	{
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
	
	public void addNeighbour(Vertex vertex)
	{
		this.adjacenciesList.add(vertex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Vertex> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public Vertex getPredecessors() {
		return predecessors;
	}

	public void setPredecessors(Vertex predecessors) {
		this.predecessors = predecessors;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
