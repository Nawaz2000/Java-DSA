import java.util.Collections;

class Node{	
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}	

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
	
}

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(5);
		n1.next = new Node(10);
		n1.next.next = new Node(7);
		
		Node it = n1;
		while (it != null) {
			System.out.println(it);
			it = it.next;
		}

	}

}
