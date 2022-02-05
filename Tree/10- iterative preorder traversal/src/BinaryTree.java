import java.util.ArrayDeque;
/*
 * Iterative preorder traversal
 * 
 * Idea: 
 * Use the inorder traversal technique but here print the node while pushing it into the stack
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(h)
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
	public static void iterativePreorder(Node root) {
		ArrayDeque<Node> stack = new ArrayDeque<Node>();
		Node curr = root;
		
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				System.out.print(curr.key + " ");
				curr = curr.left;
			}
			curr = stack.pop();
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
		
		iterativePreorder(root);

	}

}
