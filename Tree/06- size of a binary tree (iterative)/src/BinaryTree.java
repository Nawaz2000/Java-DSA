import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Find size of a binary tree (iterative)
 * 
 * Size-> Number of nodes
 * 
 * Idea:
 * Use level order traversal
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Node{
	int key;
	Node left;
	Node right;
	
	Node(int key){
		this.key = key;
	}	
}

public class BinaryTree {
	public static int findSize(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		
		int size = 0;
		while (!q.isEmpty()) {
			if (q.peek().left != null)
				q.offer(q.peek().left);
			if (q.peek().right != null)
				q.offer(q.peek().right);
			
			q.poll();
			size++;
		}
		
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.right = new Node(70);
		root.right.right.right = new Node(80);
		
		System.out.println("Size: " + findSize(root));

	}

}
