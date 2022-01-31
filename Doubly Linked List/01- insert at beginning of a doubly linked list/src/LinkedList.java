class Node{
	int data;
	Node prev;
	Node next;
	
	public Node(int data) {
		this.data = data;
		prev = next = null;
	}
}
public class LinkedList {
	
	public static Node insertAtBeginning(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null)
			return newNode;
		else {
			newNode.next = head;
			head.prev = newNode;
			return newNode;
		}
	}
	
	public static void printLinkedList(Node head) {
		if (head == null)
			return;
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtBeginning(null, 10);
		head = insertAtBeginning(head, 20);
		head = insertAtBeginning(head, 30);
		printLinkedList(head);

	}

}
