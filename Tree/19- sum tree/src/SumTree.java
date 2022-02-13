/*
 * Given a Binary Tree. Return true if, for every node X in the tree other than the 
 * leaves, its value is equal to the sum of its left subtree's value and its right 
 * subtree's value. Else return false.
 * 
 * An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. 
 * A leaf node is also considered a Sum Tree.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 * Space: Complexity: O(logn)
 */
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class SumTree {
	static boolean flag = true;

	static int sumTree(Node root) {
		if (root == null)
			return 0;
		int lSum = sumTree(root.left);
		int rSum = sumTree(root.right);

		int sum = lSum + rSum;
		if (root.left != null && root.right != null && sum != root.data)
			flag = false;
		return sum + root.data;
	}

	static boolean isSumTree(Node root) {
		sumTree(root);
		if (flag == true)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(62);
		root.left = new Node(16);
		root.right = new Node(15);
		root.left.right = new Node(8);
		root.left.right.right = new Node(8);
		root.right.left = new Node(4);
		root.right.left.left = new Node(4);
		root.right.right = new Node(7);
		
		System.out.println(isSumTree(root));

	}

}
