import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
/*
 * Strongly Connected Components (Kosaraju's Algo)
 * 
 * Idea:
 * 1. store the topological sort of graph in stack
 * 2. store transpose of graph in trans
 * 3. perform dfs on trans
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
	
	// finds the transpose of a given graph (graph) and stores it into (transpose)
	static void transpose(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> transpose, int v) {
		for (int i=0; i<v; i++) {
			ArrayList<Integer> adjacent = graph.get(i);
			for (int j : adjacent)
				addDirectedEdge(transpose, j, i);
		}
	}
	
	
	
	static int kosarajuStrong(ArrayList<ArrayList<Integer>> graph, int v) {
		int sscCount = 0;
		Stack<Integer> topo = new Stack<Integer>(); // stores the topological ordering of graph
		HashSet<Integer> visited = new HashSet<Integer>(); // visited set
		
		// setting up the transpose graph
		ArrayList<ArrayList<Integer>> trans = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<v; i++)
			trans.add(new ArrayList<Integer>());
		
		// the below for loop stores the topological ordering in a stack
		for (int start=0; start<v; start++) {
			if (!visited.contains(start))
				dfsFill(graph, topo, start, visited); // fills up topo
		}
		
		// stores the transpose of graph in trans
		transpose(graph, trans, v);		
		visited.clear();
		
		// pop from topo and for each pop, do dfs traversal of trans
		while (topo.size() > 0) {
			int start = topo.pop();
			if (!visited.contains(start)) {
//				System.out.println("SSC:");
				dfsSCC(trans, visited, start);
				sscCount++;
//				System.out.println();
			}
		}
		
		return sscCount;
	}

	// for dfs traversal of trans
	static void dfsSCC(ArrayList<ArrayList<Integer>> trans, HashSet<Integer> visited, int start) {
		visited.add(start);
//		System.out.print(start + " ");
		for (int x : trans.get(start)) {
			if (!visited.contains(x))
				dfsSCC(trans, visited, x);
		}
		
	}

	// this method fills up the stack called topo
	private static void dfsFill(ArrayList<ArrayList<Integer>> graph, Stack<Integer> topo, int start,
			HashSet<Integer> visited) {
		visited.add(start);
		for (int x : graph.get(start)) {
			if (!visited.contains(x))
				dfsFill(graph, topo, x, visited);
		}
		topo.push(start);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 5;
		for (int i=0; i<v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addDirectedEdge(graph, 0, 2);
		addDirectedEdge(graph, 0, 3);
		addDirectedEdge(graph, 1, 0);
		addDirectedEdge(graph, 2, 1);
		addDirectedEdge(graph, 3, 4);
//		addDirectedEdge(graph, 0, 1);
//		addDirectedEdge(graph, 1, 2);
//		addDirectedEdge(graph, 2, 0);
		
		printGraph(graph);
		
		int sscCount = kosarajuStrong(graph, v);
		System.out.println("Number of SSC: " + sscCount);

	}

}
