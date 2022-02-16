import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
/*
 * Topological sorting (DFS based solution)
 * 
 * Idea:
 * 1. The idea is to use dfs traversal starting from 0 to v
 * 2. Take a vertex and travel till the end of it's adjacent vertices and while
 * 	  coming back, add the adjacents to the a stack
 * Ex- if we traverse 1,2,3,4, the stack should hold 4,3,2,1 
 * 3. do this for all vertices keeping in mind not to go through the same vertex
 * 	  twice.
 * 4. In the end print stack top while emptying them
 * 
 * Time complexity: O(v+e)
 * Aux space: O(v)
 */
public class Graph {
	static void addDirectedEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	private static void dfsTopo(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited,
			Stack<Integer> s) {
		visited.add(start);
		for (int adjacent : graph.get(start)) {
			if (!visited.contains(adjacent))
				dfsTopo(graph, adjacent, visited, s);
		}
		s.push(start);
		
	}

	static void topoLogicalSortDFS(ArrayList<ArrayList<Integer>> graph, int v) {
		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		for (int i=0; i<v; i++) {
			if (!visited.contains(i))
				dfsTopo(graph, i, visited, s);
		}
		
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 5;
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addDirectedEdge(graph, 0, 1);
		addDirectedEdge(graph, 1, 3);
		addDirectedEdge(graph, 3, 4);
		addDirectedEdge(graph, 2, 3);
		addDirectedEdge(graph, 2, 4);
		
		topoLogicalSortDFS(graph, v);

	}

}
