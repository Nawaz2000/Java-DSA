import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/*
 * Detect cycle in a directed graph (Kahn's algo)
 * 
 * Idea:
 * The idea behind this algo is to use the concept of topological sorting.
 * Topological sorting only works for directed acyclic graphs. So if there is a
 * cycle, it won't work.
 * 
 * Time complexity: O(v+e)
 * Auxiliary space: O(v)
 */
public class Graph {
	private static void addDirectedEdge(ArrayList<ArrayList<Integer>> graph, int i, int j) {
		graph.get(i).add(j);		
	}
	
	private static void fillIndegree(ArrayList<ArrayList<Integer>> graph, int[] inDeg) {
		for (ArrayList<Integer> x : graph) {
			for (int y : x)
				inDeg[y]++;
		}
		
	}
	
	private static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int v) {
		int[] inDeg = new int[v];
		fillIndegree(graph, inDeg);
		
		// count stores the number of variables who after applying Kahn's algo has
		// in degree 0. If count == v, then there is no cycle
		int count = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for (int i=0; i<v; i++) {
			if (inDeg[i] == 0)
				q.add(i);
		}
		
		while (!q.isEmpty()) {
			int front = q.poll();
			count++;
			for (int i : graph.get(front)) {
				if (--inDeg[i] == 0)
					q.add(i);
			}
		}
		
		if (count != v)
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int v = 4;
		for (int i=0; i<v; i++)
			graph.add(new ArrayList<Integer>());
		
		addDirectedEdge(graph, 0, 1);
		addDirectedEdge(graph, 1, 2);
		addDirectedEdge(graph, 2, 0);
		addDirectedEdge(graph, 2, 3);
		
		System.out.println("Contains cycle: " + isCycle(graph, v));

	}

}
