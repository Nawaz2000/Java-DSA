import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
/*
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any 
 * Topological Sorting of that Graph.
 * 
 * Idea:
 * 1. use an array inDeg to find and store the in degrees of each vertices.
 * 2. loop from 0 to v once and add all those vertices whose in degrees are 0 
 * 	  in a queue
 * 3. use a loop while q is not empty, and for each front, print it and then
 * 	  traverse through the adjacent vertices of the recent front element and
 * 	  while decreasing the inDeg[current adjacent] and then check if the decreased
 * 	  value is 0 or not
 * 4. if it is 0, add it to the queue
 * 
 * Time complexity: O(v+e)
 * Auxiliary space: O(v)
 */
public class Graph {
	static void addDirectedEdges(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	// used to fill the inDegree array with the in degrees of each vertices
	private static void fillIndegree(ArrayList<ArrayList<Integer>> graph, int[] inDegree) {
		for (ArrayList<Integer> x : graph) {
			for (int y : x)
				inDegree[y]++;
		}	
	}
	
	static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int v) {
		int[] inDegree = new int[v];
		fillIndegree(graph, inDegree);
//		System.out.println(Arrays.toString(inDegree));
		
		// q stores the 0 degree elements
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		// this loop stores the elements which have in degrees 0 from before
		for (int i=0; i<v; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}
		
		while (!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front + " ");
			
			for (int i : graph.get(front)) {
				if (--inDegree[i] == 0)
					q.add(i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 5; // number of vertices in a graph
		
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addDirectedEdges(graph, 0, 2);
		addDirectedEdges(graph, 0, 3);
		addDirectedEdges(graph, 2, 3);
		addDirectedEdges(graph, 1, 3);
		addDirectedEdges(graph, 1, 4);
		
		topologicalSort(graph, v);

	}

}
