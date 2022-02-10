/*
 * Given a binary tree and two keys, find the lowest common ancestor of the two keys
 * 
 * Idea:
 * if key1 < root.key and key2 > root.key, the current root is the lca
 * if key1 and key2 is less than root.key, lca lies on left
 * else if key1 and key2 is greater than root.key, lca lies on right
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
	
	public static Node lca(Node root, int key1, int key2) {		
		if (root == null)
            return null;

        // If both n1 and n2 are smaller than root, 
        // then LCA lies in left subtree
        if (root.key > key1 && root.key > key2)
            return lca(root.left, key1, key2);

        // If both n1 and n2 are greater than root,
        // then LCA lies in right subtree
        if (root.key < key1 && root.key < key2) 
            return lca(root.right, key1, key2);

        return root;
        
        
        // OR
        
        
//      if (root == null)
//			return null;
//		
//		if (key1 == root.key || key2 == root.key)
//			return root;
//		
//		Node left = null, right = null;
//		if (key1 < root.key)
//			left = lca(root.left, key1, key2);
//		else if (key1 > root.key)
//			right = lca(root.right, key1, key2);
//		
//		if (key2 < root.key)
//			right = lca(root.left, key1, key2);
//		else if (key2 > root.key)
//			right = lca(root.right, key1, key2);
//		
//		if (left != null && right != null)
//			return root;
//		else
//			return (left != null)?left: right;
			
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
		
		int key1 = 10;
		int key2 = 22;
		
		Node res = lca(root, key1, key2);
		if (res != null)
			System.out.println(res.key);
		else
			System.out.println("LCA not found");

	}

}
