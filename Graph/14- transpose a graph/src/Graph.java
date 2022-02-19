import java.util.ArrayList;
import java.util.HashSet;
/*
 * transpose of a graph
 * 
 * Idea:
 * 1. traverse through all the vertices and their adjacent vertices
 * 2. for each adjacent vertex, point towards it's parent vertex
 * 
 * Time complexity: O(v+e)
 * Space complexity: O(v)
 */
public class Graph {
	static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for (ArrayList<Integer> x : graph) {
			for (int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}
	
	static void addDirectedEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	static void transpose(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> transpose, int v) {
		for (int i=0; i<v; i++) {
			ArrayList<Integer> adjacent = graph.get(i);
			for (int j : adjacent)
				addDirectedEdge(transpose, j, i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
		int v = 6;
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
			transpose.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(graph, 0, 1);
		addDirectedEdge(graph, 0, 2);
		addDirectedEdge(graph, 0, 3);
		addDirectedEdge(graph, 2, 1);
		addDirectedEdge(graph, 2, 3);
		addDirectedEdge(graph, 3, 4);
		addDirectedEdge(graph, 4, 0);
		
		printGraph(graph);
		
		transpose(graph, transpose, v);
		System.out.println("\nAfter transpose:");
		printGraph(transpose);

	}

}
