/*
 * Convert binary tree to it's mirror form
 * 
 * Time complexity: O(n)
 * Space Complexity: O(n)
 */
class Node{
	int key;
	Node left, right;
	Node (int key){
		this.key = key;
	}
}

public class BianryTree {
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	public static Node convertToMirror(Node root) {
		if (root == null)
            return root;
 
        Node left = convertToMirror(root.left);
        Node right = convertToMirror(root.right);
 
        /* swap the left and right pointers */
        root.left = right;
        root.right = left;
 
        return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		inorder(root);
		System.out.println();
		Node res = convertToMirror(root);
		inorder(res);

	}

}
