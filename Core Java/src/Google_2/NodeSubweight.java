package Google_2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
/*
Give you a csv file There are three columns are id, parent, weight Then give you a class Node which has these three fields 
But you also have the option of adding more fields for you to print out all the node's subwebs. 
The definition of subweight is the sum of the node's weight plus the subweight of his children.
 */
class Node 
{
    int id, weight;
    Node parent;
    List<Node> children = new ArrayList<>();
    int subweight;
}

public class NodeSubweight 
{
	private void findSubWeight(String file) throws IOException, CsvException
	{
		CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build();   // Skipping first row
		List<String[]> getAllData = csvReader.readAll();		// Parse csv and store into List
		
		Node node = new Node();
		for(String[] row : getAllData)
		{
			node.id = Integer.parseInt(row[0]);
            node.weight = Integer.parseInt(row[2]);
            int sum = node.weight;
            
            if(node.children != null)
            {
                for(Node n : node.children)
                  sum += n.weight;
            }
            node.subweight = sum;
            System.out.println(node.subweight);
		}
	}
	/*private static final Map<Integer, Node> nodeGraph = new HashMap<>();

	public static void parseCsvFile(String fileName) throws IOException
	{
	    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	        stream.forEach(s -> parseCsvRow(s));
	    }
	}

	private static void parseCsvRow(String row) 
	{
	    String[] cells = row.split(",");
	    int id = Integer.parseInt(cells[0]);
	    int parent = !cells[1].isEmpty()
	            ? Integer.parseInt(cells[1])
	            : -1;
	    int weight = Integer.parseInt(cells[2]);

	    createNode(id, parent, weight);
	}

	private static void createNode(int id, int parent, int weight)
	{
	    Node node = nodeGraph.computeIfAbsent(id, Node::new);
	    node.weight = weight;

	    Node parentNode = parent != -1
	            ? nodeGraph.computeIfAbsent(parent, Node::new)
	            : null;
	    if (parentNode != null) 
	    {
	        parentNode.children.add(node);
	        node.parent = parentNode;
	    }
	}

	public static int subWeight(Node node)
	{
	    if (node == null) return 0;

	    int weight = node.weight;
	    for (Node child : node.children) {
	        weight += subWeight(child);
	    }

	    return weight;
	}*/
	
	public static void main(String[] args) throws IOException, CsvException
	{
//		Node node = new Node(10);
//		System.out.println(subWeight(node));
		
		new NodeSubweight().findSubWeight("C:\\Users\\kruta\\Downloads\\csv_file_test.csv");
	}

	
}
