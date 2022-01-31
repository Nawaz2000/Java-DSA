/*
 * Iterative reverse a doubly linked list
 * 
 * Time complexity: O(n)
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
	
	public static Node reverse(Node head) {
		Node curr = head;
		Node next = null;
		Node prev = null;
		
		if (head == null || head.next == null)
			return head;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			if (prev != null)
				prev.prev = curr;
			prev = curr;
			curr = next;
		}
		return prev;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtEnd(null, 10);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 30);
		System.out.println("Before reversal...");
		printLinkedList(head);
		
		head = reverse(head);
		System.out.println("\nAfter reversal...");
		printLinkedList(head);

	}

}
