/*
 * Search for a key in a BST (iterative)
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 * Space complexity: O(logn)
 */
class Node{
	int key;
	Node left, right;
	Node(int key){
		this.key = key;
	}
}

public class BST {
	public static boolean search(Node root, int key) {
		if (root == null)
			return false;
		if (root.key == key)
			return true;
		if (key < root.key)
			return search(root.left, key);
		else
			return search(root.right, key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(15);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.right = new Node(20);
		root.right.right = new Node(80);
		root.right.left = new Node(18);
		root.right.left.left = new Node(16);
		
		int key = 5;
		System.out.println(search(root, key));

	}

}
