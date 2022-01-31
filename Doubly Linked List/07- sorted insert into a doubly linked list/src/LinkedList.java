/*
 * Sorted insert into a doubly linked list
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
class Node {
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

	public static Node sortedInsert(Node head, int x) {
		Node newNode = new Node(x);
		Node temp = head;
		
		// if the curr node is smaller than head
		if (head.data >= newNode.data) {
			newNode.next = head;
			temp.prev = newNode;
			return newNode;
		}

		while (temp.next != null && temp.next.data <= newNode.data)
			temp = temp.next;
		
		newNode.next = temp.next;
		// if the node is in between last and first
		if (temp.next != null) {
			temp.next.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
		} 
		// if it is the last node
		else 
		{
			newNode.prev = temp;
			temp.next = newNode;
		}

		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtEnd(null, 10);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 30);
		System.out.println("Before reversal...");
		printLinkedList(head);

		int num = 5;
		head = sortedInsert(head, num);
		System.out.println("\nAfter insertion of " + num);
		printLinkedList(head);

	}

}
