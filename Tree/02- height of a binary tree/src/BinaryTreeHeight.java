/*
 * Height of a binary tree
 * 
 * Time complexity: O(n) (when the tree is a linear data structure)
 * Space Complexity: O(h+1) or O(h), h->height of the tree
 */
class Node{
	int key;
	Node left;
	Node right;
	
	Node(int key){
		this.key = key;
	}	
}

public class BinaryTreeHeight {
	public static int height(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(30);
		root.right.left = new Node(40);
		root.right.right = new Node(50);
		root.right.right.right = new Node(60);
		System.out.println("Height: " + height(root));

	}

}
