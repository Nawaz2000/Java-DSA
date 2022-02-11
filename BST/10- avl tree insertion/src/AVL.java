import java.util.ArrayDeque;
import java.util.Queue;
/*
 * Insertion in AVL tree
 * 
 * i/p: 10,20,30,40,50,25
 * o/p: The constructed AVL Tree would be
 *           30
 *          /  \
 *        20   40
 *       /  \     \
 *      10  25    50
 * 
 * Time complexity: O(logn)
 */
class Node{
	int key, height;
	Node left, right;
	Node (int key){
		this.key = key;
		this.height = 1;
	}
}

public class AVL {
	// left rotate
	public static Node rotateRight(Node y) {
		Node x = y.left;
		Node w = x.right;
		
		x.right = y;
		y.left = w;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	// right rotate
	public static Node rotateLeft(Node y) {
		Node x = y.right;
		Node w = x.left;
		
		x.left = y;
		y.right = w;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	// returns the balance facator
	public static int getBalance(Node n) {
		if (n == null)
			return 0;
		return height(n.left) - height(n.right);
	}
	
	static int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
	
	public static Node insert(Node root, int key) {
		// if tree with current root is empty
		if (root == null)
			return new Node(key);
		// bst insert
		if (key < root.key)
			root.left = insert(root.left, key);
		else if (key > root.key)
			root.right = insert(root.right, key);
		else // rejects duplicate values
			return root;
		
		// update height of root
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		// get the balance factor
		int balance = getBalance(root);
		
		// condition for left left
		if (balance > 1 && key < root.left.key)
			return rotateRight(root);
		// condition for right right
		if (balance < -1 && key > root.right.key)
			return rotateLeft(root);
		// condition for left right
		if (balance > 1 && key > root.right.key) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		// condition for right left
		if (balance < -1 && key < root.right.key) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
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
		Node root = insert(null, 10);
		root = insert(root, 20);
		root = insert(root, 30);
		root = insert(root, 40);
		root = insert(root, 50);
		root = insert(root, 25);
		levelOrder(root);

	}

}
