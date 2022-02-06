import java.util.ArrayDeque;
import java.util.Queue;
/*
 *  Given a Binary Tree and a Key. The task is to insert the key into the binary tree at 
 *  first position available in level order.
 *  
 *  i/p:
 *          10
 *         /  \
 *        11   9     , int key = 12
 *       /      \
 *      7        8
 *      
 *  o/p:
 *          10
 *         /   \
 *        11    9
 *       /  \    \
 *      7    12   8
 *      
 *  
 *  Time complexity: O(n)
 *  Auxiliary space: O(h)
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
	
	public static void insert(Node root, int key) {
		Node newNode = new Node(key);
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(root);
		while (!q.isEmpty()) {
			// if left is empty, insert into left, break
			if (q.peek().left == null) {
				q.peek().left = newNode;
				return;
			}
			// if right is empty, insert into right, break
			if (q.peek().right == null) {
				q.peek().right = newNode;
				return;
			}
			
			// else add left and right childs
			if (q.peek().left != null)
				q.offer(q.peek().left);
			if (q.peek().right != null)
				q.offer(q.peek().right);
			q.poll();
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
		
		System.out.println("After");
		int key = 12;
		insert(root, key);
		breadthFirst(root);

	}

}
