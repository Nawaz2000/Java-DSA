
public class TreeTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		
		System.out.println("Preorder traversal");
		bt.printPreorder();
		
		System.out.println("\nInorder traversal");
		bt.printInorder();
		
		System.out.println("\nPostorder traversal");
		bt.printPostorder();

	}

}
