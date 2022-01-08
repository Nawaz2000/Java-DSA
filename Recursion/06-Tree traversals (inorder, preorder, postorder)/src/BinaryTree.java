
public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void printPreorder(Node node) {
		if (node == null)
			return;
		
		System.out.println(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public void printInorder(Node node) {
		if (node == null)
			return;
		
		printInorder(node.left);
		System.out.println(node.key + " ");
		printInorder(node.right);
	}
	
	public void printPostorder(Node node) {
		if (node == null)
			return;
		
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.println(node.key);
	}
	
	void printPostorder()
	{
		printPostorder(root);
	}
	
    void printInorder() 
    { 
    	printInorder(root); 
    }
    
    void printPreorder() 
    { 
    	printPreorder(root); 
    }
	
	
}
