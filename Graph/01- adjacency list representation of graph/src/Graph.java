import java.util.ArrayList;
/*
 * An adjacency list representation of graph
 * 
 * Time complexity:
 * Adding a vertex: O(1)
 * Adding an edge: O(1)
 */
public class Graph {
	private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		// TODO Auto-generated method stub
		graph.get(u).add(v);
		graph.get(v).add(u);
		
	}
	
	// method to print the graph
	static void printAdjacencyListGraph(ArrayList<ArrayList<Integer>> graph) {
		for (ArrayList<Integer> x : graph) {
			for (int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 5; // no. of vertices
		
		// adding vertices
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		// adding edges
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		
		printAdjacencyListGraph(graph);

	}
}
