import java.util.ArrayList;
import java.util.HashSet;
/*
 * Detect cycles in an undirected graph
 * 
 * Idea:
 * 1. we use dfs
 * 2. we use parent variable
 * 3. if (current is visited before and is not equal to parent) return true
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
	
	static boolean dfs(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited, int parent) {
		visited.add(start);
		for (int adjacent : graph.get(start)) {
			if (!visited.contains(adjacent)) {
				boolean res = dfs(graph, adjacent, visited, start);
				if (res == true)
					return true;
			}
			else if (visited.contains(adjacent) && adjacent != parent)
				return true;
		}
		return false;
	}
	
	static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, int v) {
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i=0; i<v; i++) {
			if (!visited.contains(i)) {
				boolean res = dfs(graph, i, visited, -1);
				if (res == true)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 11;
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 0, 4);
		addEdge(graph, 4, 5);
		addEdge(graph, 4, 6);
		addEdge(graph, 7, 8);
		addEdge(graph, 8, 9);
		addEdge(graph, 7, 9);
		
		//printGraph(graph);
		System.out.println("Contains cycle: " + detectCycle(graph, v));

	}

}
