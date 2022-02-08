import java.util.ArrayDeque;
import java.util.Queue;
/*
 * Delete a key in a BST
 * 
 * Idea: 
 * the node to be deleted is either of the 3 below types:
 * 1. leaf node (just delete the leaf node)
 * 2. has only one child (parent.next = node.child)
 * 3. has both children (replace the node with it's inorder successor and then delete
 * 	  the inorder successor
 * 
 * Time complexity: O(logn)
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
	
	// returns the first inorder successor
	public static Node getSuccessor(Node root) {
		Node curr = root.right;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}
	
	public static Node delete(Node root, int key) {
		if (root == null)
			return null;
		if (key < root.key)
			root.left = delete(root.left, key);
		else if (key > root.key)
			root.right = delete(root.right, key);
		
		// this else part executes when node to be deleted is found
		else {
			// the if and else if part is executed if the node to be deleted has only
			// one child or is a leaf node
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			// executed if the node to be deleted has both children. Here the node.key
			// is replaced with the next bigger node (inorder successor) and then the 
			// inorder successor is itself deleted
			else {
				Node successor = getSuccessor(root);
				root.key = successor.key;
				root.right = delete(root.right, successor.key);
			}
		}
		
		return root;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = insert(null, 15);
		root = insert(root, 5);
		root = insert(root, 3);
		root = insert(root, 20);
		root = insert(root, 17);
		root = insert(root, 80);
		root = insert(root, 16);
		root = insert(root, 19);
		root = insert(root, 18);
		
		System.out.println("Before: ");
		levelOrder(root);
		
		int key = 17;
		root = delete(root, key);
		System.out.println("After deletion of: " + key);
		delete(root, key);
		levelOrder(root);

	}

}
