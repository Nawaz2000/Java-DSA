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
	
	static boolean flag = false;
	static boolean recursiveDFS(ArrayList<ArrayList<Integer>> graph, int source, 
			HashSet<Integer> visited, int parent) {
		visited.add(source);
//		System.out.print(source + " ");
		for (int x : graph.get(source)) {
			if (!visited.contains(x)) {
				boolean res = recursiveDFS(graph, x, visited, source);
				if (res == true)
					return true;
			}
			else if (x != parent)
				return true;
		}
		return false;
	}
	
	static void dfs(ArrayList<ArrayList<Integer>> graph, int source) {
		HashSet<Integer> visited = new HashSet<Integer>();
		System.out.println(recursiveDFS(graph, source, visited, -1));
		
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
