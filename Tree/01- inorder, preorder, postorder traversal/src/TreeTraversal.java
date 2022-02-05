/*
 * Inorder, preorder and postorder traversal of a tree
 * 
 * Time complexity: O(n)
 * Space Complexity: O(height)
 */
class Node{
	int key;
	Node left;
	Node right;
	
	Node(int key){
		this.key = key;
	}
	
}

public class TreeTraversal {
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			inorder(root.left);
			inorder(root.right);
		}
	}
	
	public static void postorder(Node root) {
		if (root != null) {
			inorder(root.left);
			inorder(root.right);
			System.out.print(root.key + " ");
		}
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
		
		System.out.print("Inorder: ");
		inorder(root);
		System.out.println();
		System.out.print("Preorder: ");
		preorder(root);
		System.out.println();
		System.out.print("Postorder: ");
		postorder(root);

	}

}
