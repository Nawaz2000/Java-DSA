import java.util.ArrayDeque;
import java.util.Queue;
/*
 * Breadth first traversal of a binary tree
 * 
 * Idea: 
 * use a queue to store child nodes at every level
 * 1. Use a queue. Store the root as the first element
 * 2. Use a loop till q is not empty
 * 3. In each loop, enqueue the front's left and right child and then dequeue the front
 * 	  display the data
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n/2) = O(n) (at any point of time, the queue holds a level of the tree)
 * or we can say that the auxiliary space is equal to the breadth of the tree
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
	public static void breadthFirst(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		
		while (!q.isEmpty()) {
			if (q.peek().left != null)
				q.offer(q.peek().left);
			if (q.peek().right != null)
				q.offer(q.peek().right);
			
			System.out.print(q.poll().key + " ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.right = new Node(70);
		
		breadthFirst(root);

	}

}
