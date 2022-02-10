/*
 *  Given a Binary Tree and the value of two nodes n1 and n2. The task is to find the 
 *  lowest common ancestor of the nodes n1 and n2 in the given Binary Tree.
 *  
 *  i/p:
 *          10
 *         /  \
 *        11   9     ,  key1 = 7, key2 = 9
 *       /    / \
 *      7    15  8
 *      
 *  o/p: 10 (as it is the lowest common ancestor)
 *  
 *  Idea:
 *  The idea is to traverse the tree starting from the root. If any of the given keys 
 *  (n1 and n2) matches with the root, then the root is LCA (assuming that both keys are 
 *  present). If the root doesn’t match with any of the keys, we recur for the left and 
 *  right subtree. The node which has one key present in its left subtree and the other 
 *  key present in the right subtree is the LCA. If both keys lie in the left subtree, 
 *  then the left subtree has LCA also, otherwise, LCA lies in the right subtree.  
 *  
 *  Time complexity: O(n)
 *  Auxiliary space: O(1)
 *  
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
	// finds the lowest common ancestor
	public static int lowestCommonAncestor(Node root, int key1, int key2) {
		if (root == null)
			return -1;
		
		if (root.key == key1 || root.key == key2)
			return root.key;
		int left = lowestCommonAncestor(root.left, key1, key2);
		int right = lowestCommonAncestor(root.right, key1, key2);
		
		if (left != -1 && right != -1) // current root is the ancestor
			return root.key;
		return (left != -1)?left:right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		int key1 = 15;
		int key2 = 8;
		System.out.println("LCA of " + key1 + ", " + key2 + " is: " + lowestCommonAncestor(root, key1, key2));
		

	}

}
