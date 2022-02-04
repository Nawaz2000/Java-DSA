/*
 * Find size of a binary tree
 * 
 * Size-> Number of nodes
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
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
		return 1 + findSize(root.left) + findSize(root.right);
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
