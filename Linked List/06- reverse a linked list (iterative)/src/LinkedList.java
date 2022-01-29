class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
}
public class LinkedList {
	public static void printLinkedList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	public static Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;
				
		Node nextNode = null;
		Node prevNode = null;
		Node currNode = null;
		
		prevNode = null;
		currNode = head;
		
		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		
		return prevNode;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		System.out.println("Given linked list:");
		printLinkedList(head);
		
		System.out.println("\nAfter reversing:");
		Node newHead = reverse(head);
		printLinkedList(newHead);

	}
	
}
