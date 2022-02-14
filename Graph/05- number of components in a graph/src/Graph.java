import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
/*
 * Find number of components in a graph
 * 
 * Idea: 
 * use the same technique as bfs traversal of a disjointed graph and count the number of times
 * the loop runs
 * 
 * Time complexity: O(v+e), v-> number of vertices in a graph
 * Auxiliary space: O(v)
 */
public class Graph {
	static void addEdges(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for (ArrayList<Integer> x : graph) {
			for (int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}
	
	static int components = 0; // stores the number of components
	
	static void BFS(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited) {
		if (graph == null || visited.contains(start))
			return;
		components++;
		System.out.print("a ");
		Queue<Integer> q = new ArrayDeque<Integer>(); // stores the vertices
		q.add(start);
		HashSet<Integer> set = new HashSet<Integer>(); // keeps track of all visited vertices
		set.add(start);
		visited.add(start);
		
		while (!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front + " ");
			ArrayList<Integer> list = graph.get(front);
			for (int i : list) {
				// if the vertex was not visited previously, we add it to the queue
				if (!set.contains(i)) {
					set.add(i);
					visited.add(i);
					q.add(i);
				}
			}
		}
		System.out.println();
		
	}
	
	// execution begins here
	static void components(ArrayList<ArrayList<Integer>> graph, int v) {
		// stores the vertices already visited.
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i=0; i<v; i++)
			BFS(graph, i, visited);	
		System.out.println("Number of components: " + components);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 7; // number of vertices in a graph
		
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addEdges(graph, 0, 1);
		addEdges(graph, 0, 3);
		addEdges(graph, 1, 2);
		addEdges(graph, 2, 3);
		addEdges(graph, 4, 5);
		addEdges(graph, 4, 6);
		addEdges(graph, 5, 6);
		
//		printGraph(graph);
		
		System.out.println("BFS:");
		components(graph, v);

	}

}
