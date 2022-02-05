/*
 * Find maximum in a binary tree
 * 
 * Time complexity: O(n)
 * Space complexity: O(height)
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
	public static int findMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.key, Math.max(findMax(root.left), findMax(root.right)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(60);
		root.left.right = new Node(50);
		root.right.right = new Node(70);
		root.right.right.right = new Node(80);
		
		System.out.println("Max: " + findMax(root));

	}

}
