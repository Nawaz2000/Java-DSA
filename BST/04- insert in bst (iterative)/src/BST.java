import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Insert a key in a BST (iterative)
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
	public static Node insert(Node root, int key) {
		Node temp = new Node(key);
		Node curr = root;
		if (root == null) {
			root = temp;
			return root;
		}
		while (curr != null) {
			if (key < curr.key) {
				if (curr.left == null) {
					curr.left = temp;
					break;
				}
				else
					curr = curr.left;
			}else {
				if (curr.right == null) {
					curr.right = temp;
					break;
				}
				else
					curr = curr.right;
			}
		}
		return root;
	}
	
	public static void levelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		while (!q.isEmpty()) {
			if (q.peek().left != null)
				q.offer(q.peek().left);
			if (q.peek().right != null)
				q.offer(q.peek().right);
			System.out.print(q.poll().key + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node root = new Node(15);
//		root.left = new Node(5);
//		root.left.left = new Node(3);
//		root.right = new Node(20);
//		root.right.right = new Node(80);
//		root.right.left = new Node(18);
//		root.right.left.left = new Node(16);
		
		Node root = insert(null, 15);
		root = insert(root, 5);
		System.out.println("Before: ");
		levelOrder(root);
		root = insert(root, 3);
		root = insert(root, 20);
		root = insert(root, 80);
		root = insert(root, 18);
		root = insert(root, 16);
		
		System.out.println("After: ");
		levelOrder(root);
	}

}
