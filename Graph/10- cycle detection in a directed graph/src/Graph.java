import java.util.ArrayList;
import java.util.HashSet;
/*
 * Cycle detection in a directed graph using dfs
 * 
 * Idea: 
 * 1. we use dfs technique along with an extra set called ancestor
 * 2. the ancestor set maintains the visited vertices in each connected component
 * 3. if visited set contains i and ancestor also contains i then there is a cycle
 * 
 * Time complexity: O(v+e), v-> number of vertices in a graph
 * Auxiliary space: O(v)
 */
public class Graph {
	static void addDirectedEdges(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	static boolean dfsDirected(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited,
			HashSet<Integer> ancestor) {
		visited.add(start);
		ancestor.add(start);
		
		for (int i : graph.get(start)) {
			if (!visited.contains(i)) {
				boolean res = dfsDirected(graph, i, visited, ancestor);
				if (res == true)
					return true;
			}else if (
				ancestor.contains(i))
				return true;
		}
		ancestor.remove(start);
		return false;
	}
	
	static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int v) {
		// stores the visited nodes
		HashSet<Integer> visited = new HashSet<Integer>(); 
		// stores the ancestors for each connected component
		HashSet<Integer> ancestor = new HashSet<Integer>();
		
		// loops through each connected components
		for (int i=0; i<v; i++) {
			if (!visited.contains(i)) {
				boolean res = dfsDirected(graph, i, visited, ancestor);
				if (res == true)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 6; // number of vertices in a graph
		
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addDirectedEdges(graph, 0, 1);
		addDirectedEdges(graph, 1, 2);
//		addDirectedEdges(graph, 2, 2);
//		addDirectedEdges(graph, 3, 1);
//		addDirectedEdges(graph, 2, 3);
//		addDirectedEdges(graph, 3, 1);
		
		System.out.println("Contains cycle: " + isCycle(graph, v));
		

	}

}
