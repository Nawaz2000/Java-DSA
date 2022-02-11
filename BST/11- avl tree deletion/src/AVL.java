import java.util.ArrayDeque;
import java.util.Queue;
/*
 * Deletion in AVL tree
 * 
 * i/p: 10,20,30,40,50,25, delete 40,50
 * o/p: The constructed AVL Tree would be
 *           30
 *          /  \
 *        20   40
 *       /  \     \
 *      10  25    50
 *      
 * After deleting 40,50
 *           20
 *          /  \
 *        10   30
 *            /
 *           25 
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
	
	public static Node delete(Node root, int key) {
		if (root == null)
			return null;
		if (key < root.key)
			root.left = delete(root.left, key);
		else if (key > root.key)
			root.right = delete(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				Node succ = getSuccessor(root);
				root.key = succ.key;
				root.right = delete(root.right, succ.key);
			}
		}
		
		// upto this point there was normal bst deletion. From here, we do the balancing
//		if (root == null)
//			return null;
		
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		int balance = getBalance(root);
		
		// Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRight(root);
 
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return rotateLeft(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
 
        return root;
	}
	
	public static Node getSuccessor(Node root) {
		Node curr = root.right;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr;
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
		
		root = delete(root, 40);
		root = delete(root, 50);
		levelOrder(root);

	}

}
