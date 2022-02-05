import java.util.ArrayDeque;
import java.util.LinkedHashSet;

/*
 * Iterative inorder traversal
 * 
 * Idea:
 * 1. Use a set to keep track of items that were once entered into stack
 * 2. Use a loop till stack is not empty
 * 	a. if top.left is not null and top.left is not in set, enter it both into set and stack
 * 	b. if top.left is not null and top.left is in set, pop and print top and push top.right 
 * 	   into set and stack
 * 	c. if top doesn't have a left child but have a right child, pop and print top and push 
 * 	   top.right into stack and set
 * 	d. if top is a leaf node, pop top and print
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n) (for using set)
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
	public static void iterativeInorder(Node root) {
		ArrayDeque<Node> stack = new ArrayDeque<Node>();
		LinkedHashSet<Node> set = new LinkedHashSet<Node>();
		if (root == null)
			return;
		stack.push(root);
		set.add(root);
		
		while (!stack.isEmpty()) {
			if (stack.peek().left != null) {
				if (!set.contains(stack.peek().left)) {
					set.add(stack.peek().left);
					stack.push(stack.peek().left);
				}else {
					Node temp = stack.peek().right;
					System.out.print(stack.pop().key + " ");
					stack.push(temp);
					set.add(temp);
				}
				
			}
			else {
				if (stack.peek().right != null) {
					if (!set.contains(stack.peek().right)) {
						Node temp = stack.peek().right;
						System.out.print(stack.pop().key + " ");
						stack.push(temp);
						set.add(temp);
					}
				}else
					System.out.print(stack.pop().key + " ");
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(60);
		root.left.right = new Node(50);
		root.right.right = new Node(70);
		root.right.right.right = new Node(80);
//		root.right.right.right.right = new Node(90);
		
		iterativeInorder(root);

	}

}
