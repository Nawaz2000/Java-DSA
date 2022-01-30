/*
 * Delete head of a circular linked list
 * 
 * Idea:
 * Swap the data between head and temp (which is head.next)
 * set head.next = temp.next
 * 
 * Time complexity: O(1)
 * Auxiliary space: O(1)
 */
class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {
	
	public static void printCircularLinkedList(Node head) {
		if (head == null)
			return;
		Node curr = head;
		while (curr.next != head) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	public static Node deleteHead(Node head) {
		// if the head itself is null or if there is only one node, return null
		if (head == null || head.next == head)
			return null;
		
		Node temp = head.next;
		int t = head.data;
		head.data = temp.data;
		temp.data = t;
		
		head.next = temp.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next = head;
		System.out.println("Before deletion: ");
		printCircularLinkedList(head);
		
		head = deleteHead(head);
		System.out.println("\nAfter deletion: ");
		printCircularLinkedList(head);
		
		head = deleteHead(head);
		System.out.println("\nAfter deletion: ");
		printCircularLinkedList(head);

	}

}
