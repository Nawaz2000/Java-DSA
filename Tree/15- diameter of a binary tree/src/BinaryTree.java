/*
 * The diameter of a tree (sometimes called the width) is the number of nodes on the 
 * longest path between two end nodes. The diagram below shows two trees each with 
 * diameter nine, the leaves that form the ends of a longest path are shaded (note that 
 * there is more than one path in each tree of length nine, but no path longer than nine 
 * nodes).
 * 
 * Idea:
 * 1. Height of a binary tree is is the [1 + Max(height of left, height of right)]
 * 2. maxHeight = max(maxHeight, (1+lHeight+rHeight))
 * 3. recursively traverse left, right and do the above
 * 
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
class Node{
	int key;
	Node left,right;
	Node(int key){
		this.key = key;
	}
}

public class BinaryTree {
	static int max = 0; // stores the maximum diameter
	
	public static int diameter(Node root) {
		if (root == null)
			return 0;
		int lHeight = diameter(root.left);
		int rHeight = diameter(root.right);
		
		// lHeight +rHeight gives us the number of edges. So to find the number of nodes,
		// we add 1 to the number of edges
		max = Math.max(max, 1 + (lHeight + rHeight));
		
		return 1 + Math.max(lHeight, rHeight);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.left.left = new Node(30);
		root.left.left.right = new Node(40);
		root.left.right = new Node(50);
		root.left.right.right = new Node(60);
		root.left.right.right.left = new Node(70);
		root.right = new Node(80);
		root.right.left = new Node(90);
		root.right.right = new Node(100);
		root.right.right.left = new Node(110);
		
		diameter(root);
		System.out.println("Diameter: " + max);

	}

}
