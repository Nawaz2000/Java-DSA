import java.util.ArrayDeque;
/*
 *  Given a Binary Tree and a Key. The task is to delete the key from the binary tree.
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
	static ArrayDeque<Node> stack = new ArrayDeque<Node>();
	
	public static void getPath(Node root, int key){
		if (root != null) {
			stack.push(root);
			if (stack.peek().key == key)
				return;
			getPath(root.left, key);
			getPath(root.right, key);
			if (!stack.isEmpty() && stack.peek() == root)
				stack.pop();
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
		
		for (Node n : stack)
			System.out.print(n.key + " ");

	}

}
