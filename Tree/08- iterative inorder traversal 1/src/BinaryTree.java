import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 * Iterative inorder traversal
 * 
 * Idea:
 * 1. Use a set to keep track of items that were once entered into stack
 * 2. Use a loop till stack is not empty
 * 	a. use another loop till top.left is not null and in that loop keep pushing top.left
 * 	b. After coming out of the inner loop, pop top and print it.
 * 	c. if top has a right child, add it to the stack
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(h) (for using set)
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
		HashSet<Node> set = new HashSet<Node>();
		Node curr = root;
		stack.push(curr);
		while (!stack.isEmpty()) {
			while (stack.peek().left != null && !set.contains(stack.peek().left)) {
				stack.push(stack.peek().left);
				set.add(stack.peek());
			}
			Node temp = stack.pop();
			System.out.print(temp.key + " ");
			if (temp.right != null) {
				stack.push(temp.right);
				set.add(stack.peek());
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
