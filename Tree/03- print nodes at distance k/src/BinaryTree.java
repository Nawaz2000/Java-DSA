/*
 * Print nodes at a distance of k from root
 * 
 * Time complexity: O(n)
 * Space complexity: O(height)
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
	public static void printNodesAtDistance(Node root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.print(root.key + " ");
			return;
		}
		printNodesAtDistance(root.left, k-1);
		printNodesAtDistance(root.right, k-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.right = new Node(70);
		
		printNodesAtDistance(root, 2);

	}

}
