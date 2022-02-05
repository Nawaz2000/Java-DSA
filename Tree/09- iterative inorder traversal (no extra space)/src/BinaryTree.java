import java.util.ArrayDeque;

/*
 * Iterative inorder traversal
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n) (for using set)
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
	public static void iterativeInorder(Node root) {
		ArrayDeque<Node> stack = new ArrayDeque<Node>();
		Node curr = root;
		
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
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
//		root.right.right.right.right = new Node(90);
		
		iterativeInorder(root);

	}

}
