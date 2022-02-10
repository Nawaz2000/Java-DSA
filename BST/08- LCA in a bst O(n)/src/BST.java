/*
 * Given a binary tree and two keys, find the lowest common ancestor of the two keys
 * 
 * Idea:
 * if a node is a key, it returns 1
 * if both left and right childs passes 1, then it is the lca
 * if one child returns 1,return 1 else 0
 * 
 * Time complexity: O(n)
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
	
	static Node lca;
	
	public static int lca(Node root, int key1, int key2) {
		if (root == null)
			return 0;
		
		if (root.key == key1 || root.key == key2)
			return 1;
		
		int left = lca(root.left, key1, key2);
		int right = lca(root.right, key1, key2);
		
		if (left == 1 && right == 1)
			lca = root;
		
		return (left == 1)?left:right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = insert(null, 20);
		root = insert(root, 8);
		root = insert(root, 22);
		root = insert(root, 4);
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 14);
		
		int key1 = 4;
		int key2 = 14;
		
		lca(root, key1, key2);
		if (lca != null)
			System.out.println(lca.key);
		else
			System.out.println("LCA not found");

	}

}
