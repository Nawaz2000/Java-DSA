import java.util.ArrayDeque;
import java.util.Queue;

/*
 *  Given a Binary Tree and a Key. The task is to delete the key from the binary tree.
 *  
 *  i/p:
 *          10
 *         /  \
 *        11   9     , int key = 11
 *       /      \
 *      7        8
 *      
 *  o/p:
 *          10
 *         /   \
 *        8     9
 *       /  \    
 *      7    12   
 *      
 *  Idea:
 *  1. Find the node containing the key (keyNode)
 *  2. find the parent node of the last or deepest node (secLast)
 *  3. replace the key of keyNode with that of the key in the secLast's child
 *  4. delete secLast's child
 *  
 *  Time complexity: O(n)
 *  Auxiliary space: O(h)
 */
class Node {
	int key;
	Node left;
	Node right;

	Node(int key) {
		this.key = key;
	}
}

public class BinaryTree {
	// for level order traversal
	public static void breadthFirst(Node root) {
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		while (!q.isEmpty()) {
			if (q.peek().left != null)
				q.offer(q.peek().left);
			if (q.peek().right != null)
				q.offer(q.peek().right);
			System.out.print(q.poll().key + " ");
		}
	}

	// finds the parent of the last or deepest node
	public static Node findSecLast(Node root) {
		Node curr = root;
		while (curr.left != null || curr.right != null) {
			if (curr.right != null) {
				if (curr.right.left == null && curr.right.right == null)
					break;
				curr = curr.right;
			} else if (curr.left != null) {
				if (curr.left.left == null && curr.left.right == null)
					break;
				curr = curr.left;
			}

		}
		return curr;
	}

	// finds the node containing the key
	public static Node findKeyNode(Node root, int key) {
		if (root == null)
			return root;

		if (root.key == key)
			return root;

		Node res1 = findKeyNode(root.left, key);

		if (res1 != null)
			return res1;

		Node res2 = findKeyNode(root.right, key);
		return res2;

	}

	public static void delete(Node root, int key) {
		Node secLast = findSecLast(root);
		Node keyNode = findKeyNode(root, key);

		if (secLast != null && keyNode != null) {
			if (secLast.right != null) {
				keyNode.key = secLast.right.key;
				secLast.right = null;
			} else if (secLast.left != null) {
				keyNode.key = secLast.left.key;
				secLast.left = null;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		System.out.println("Before");
		breadthFirst(root);

		System.out.println();

		int key = 1;
		System.out.println("After deletion of: " + key);
		delete(root, key);
		breadthFirst(root);

	}

}
