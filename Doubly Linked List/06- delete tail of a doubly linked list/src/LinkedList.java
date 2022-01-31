/*
 * Delete tail of a doubly linked list
 * 
 * Time complexity: O(1)
 * Auxiliary space: O(1)
 */
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
	public static void printLinkedList(Node head) {
		if (head == null)
			return;
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
	public static Node insertAtEnd(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null)
			return newNode;
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		
		curr.next = newNode;
		newNode.prev = curr;
		
		return head;
	}
	
	public static Node deleteTail(Node head) {
		if (head == null || head.next == null)
			return head;
		Node curr = head;
		while (curr.next.next != null)
			curr = curr.next;
		curr.next = null;
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtEnd(null, 10);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 30);
		System.out.println("Before reversal...");
		printLinkedList(head);
		
		head = deleteTail(head);
		System.out.println("\nAfter deletion of tail...");
		printLinkedList(head);

	}

}
