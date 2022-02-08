/*
 * Search for a key in a BST (iterative)
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 * Space complexity: O(1)
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
		Node curr = root;
		while (curr != null) {
			if (curr.key == key)
				return true;
			if (key < curr.key)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return false;
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
		
		int key = 169;
		System.out.println(search(root, key));

	}

}
