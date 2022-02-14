import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
/*
 * BFS traversal of a directed graph when source is given
 * 
 * Idea: 
 * we use the same bfs technique as used for tree only this time we use an aux array to mark
 * if the vertex was visited before
 * 
 * Time complexity: O(v), v-> number of vertices in a graph
 * Auxiliary space: O(v)
 */
public class Graph {
	static void addDirectedEdges(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for (ArrayList<Integer> x : graph) {
			for (int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}
	
	static void BFS(ArrayList<ArrayList<Integer>> graph, int start) {
		if (graph == null)
			return;
		Queue<Integer> q = new ArrayDeque<Integer>(); // stores the vertices
		q.add(start);
		HashSet<Integer> set = new HashSet<Integer>(); // keeps track of all visited vertices
		set.add(start);
		
		while (!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front + " ");
			ArrayList<Integer> list = graph.get(front);
			for (int i : list) {
				// if the vertex was not visited previously, we add it to the queue
				if (!set.contains(i)) {
					set.add(i);
					q.add(i);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 6; // number of vertices in a graph
		
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addDirectedEdges(graph, 0, 1);
		addDirectedEdges(graph, 0, 2);
		addDirectedEdges(graph, 1, 2);
		addDirectedEdges(graph, 2, 1);
		addDirectedEdges(graph, 2, 3);
		addDirectedEdges(graph, 3, 1);
		
		printGraph(graph);
		
		System.out.println("BFS:");
		BFS(graph, 0);

	}

}
