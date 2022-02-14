import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
/*
 * BFS traversal of a graph when source is given
 * 
 * Idea: 
 * we use the same bfs technique as used for tree only this time we use an aux array to mark
 * if the vertex was visited before.
 * 
 * As the graph is disjointed, we use an additional HashSet (visited) to mark the nodes visited
 * The execution begins from disjointedBFS. looping from 0 <= i < v. But only executing the
 * loop id i is not found in visited set
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
	
	static void BFS(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited) {
		if (graph == null || visited.contains(start))
			return;
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
	static void disjointedBFS(ArrayList<ArrayList<Integer>> graph, int v) {
		// stores the vertices already visited.
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i=0; i<v; i++)
			BFS(graph, i, visited);		
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
		disjointedBFS(graph, v);

	}

}
