/*
 * Given a binary tree and a key(node) value, find the floor value for that particular 
 * key value.
 * 
 * Floor Value Node: Node with the greatest data lesser than or equal to the key value.
 * 
 * Idea:
 * Iterative solution for best outcome
 * 1. Mark the ceil as -1 initially.
 * 2. if val is equal to root.key, return root.key as the floor
 * 3. if val < root.key, update floor to root.key and set curr to curr.ceil
 * 4. else, floor lies on right. So set curr to curr.right
 * 
 * Time complexity: O(logn)
 * Auxiliary Space: O(1)
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
		if (root == null)
			return temp;
		if (key < root.key)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		
		return root;
	}
	
	public static int ceil(Node root, int val) {
		int ceil = -1;
		Node curr = root;
		if (root == null)
			return ceil;
		
		while (curr != null) {
			if (val == curr.key)
				return curr.key;
			if (val < curr.key) {
				ceil = curr.key;
				curr = curr.left;
			}else
				curr = curr.right;
		}
		
		return ceil;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = insert(null, 50);
		root = insert(root, 30);
		root = insert(root, 70);
		root = insert(root, 20);
		root = insert(root, 40);
		root = insert(root, 60);
		root = insert(root, 80);
		root = insert(root, 55);
		root = insert(root, 65);
		
		int val = 48;
		System.out.println("Floor of " + val + " is: " + ceil(root, val));

	}

}
