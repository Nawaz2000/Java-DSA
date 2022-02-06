import java.util.LinkedList;
/*
 * Find route to a key in a binary tree
 * 
 * Idea:
 * 1. Traverse the tree recursively (left then right)
 * 2. if stack.peek.key == key, return
 * 3. recurse left
 * 4. recurse right
 * 5. if stack.top == currNode, stack.pop
 * 
 * Time complexity: O(n)
 * Space complexity: O(h)
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
	static LinkedList<Node> dq = new LinkedList<Node>();
	
	public static void getPath(Node root, int key) {
		if (root != null) {
			dq.push(root);
			if (dq.peek().key == key)
				return;
			getPath(root.left, key);
			getPath(root.right, key);
			if (!dq.isEmpty() && dq.peek() == root)
				dq.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		int key = 15;
		getPath(root, key);
		
		while (!dq.isEmpty())
			System.out.print(dq.pollLast().key + " ");

	}

}
