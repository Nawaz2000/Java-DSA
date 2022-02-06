import java.util.ArrayDeque;
import java.util.HashSet;
/*
 *  Given a Binary Tree and the value of two nodes n1 and n2. The task is to find the 
 *  lowest common ancestor of the nodes n1 and n2 in the given Binary Tree.
 *  
 *  i/p:
 *          10
 *         /  \
 *        11   9     ,  key1 = 7, key2 = 9
 *       /    / \
 *      7    15  8
 *      
 *  o/p: 10 (as it is the lowest common ancestor)
 *  
 *  Idea:
 *  Find the route of both the keys and check for the nearest matching key
 *  
 *  Time complexity: O(n)
 *  Auxiliary space: O(h)
 *  
 */
class Node {
	int key;
	Node left;
	Node right;

	Node(int key) {
		this.key = key;
	}
}

public class BinaryTree {
	// finds the route for each key
	public static void findRoute(ArrayDeque<Node> dq1, Node root, int key){
		if (root != null) {
			dq1.push(root);
			if (dq1.peek().key == key)
				return;
			findRoute(dq1, root.left, key);
			findRoute(dq1, root.right, key);
			if (!dq1.isEmpty() && dq1.peek() == root)
				dq1.pop();
		}
		
	}
	
	// finds the lowest common ancestor
	public static int lowestCommonAncestor(Node root, int key1, int key2) {
		ArrayDeque<Node> stack1 = new ArrayDeque<Node>();// holds path of 
		ArrayDeque<Node> stack2 = new ArrayDeque<Node>();
		findRoute(stack1, root, key1);
		findRoute(stack2, root, key2);
		
		HashSet<Integer> set = new HashSet<Integer>();

		while (!stack1.isEmpty()) {
			set.add(stack1.pop().key);
		}
		while (!stack2.isEmpty()) {
			if (set.contains(stack2.peek().key))
				return stack2.pop().key;
			stack2.pop();
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		int key1 = 15;
		int key2 = 8;
		System.out.println("LCA of " + key1 + ", " + key2 + " is: " + lowestCommonAncestor(root, key1, key2));
		

	}

}
