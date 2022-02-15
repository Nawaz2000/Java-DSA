import java.util.ArrayList;
import java.util.HashSet;
/*
 * dfs traversal of undirected graph (source is given)
 * 
 * Idea:
 * 1. we use a hashset (visited) to mark the vertices already visited
 * 2. use recursion to visit neighboring vertices and print them along the way
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
	
	static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	
	static void recursiveDFS(ArrayList<ArrayList<Integer>> graph, int source, HashSet<Integer> visited) {
		visited.add(source);
		System.out.print(source + " ");
		
		// this for loop goes for the adacent vertices
		for (int u : graph.get(source)) {
			if (!visited.contains(u))
				recursiveDFS(graph, u, visited);
		}
	}
	
	static void dfs(ArrayList<ArrayList<Integer>> graph, int source) {
		HashSet<Integer> visited = new HashSet<Integer>();
		recursiveDFS(graph, source, visited);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 7;
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 0, 4);
		addEdge(graph, 4, 5);
		addEdge(graph, 4, 6);
		addEdge(graph, 5, 6);
		
		//printGraph(graph);
		dfs(graph, 0);

	}

}
