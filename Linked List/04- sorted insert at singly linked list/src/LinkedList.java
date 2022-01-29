/*
 * Given a sorted linked list, insert an element such that the linked list remains sorted
 * 
 * Time complexity: O(n)
 * Auxiliary spacec: O(1)
 */
class Node {
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
	
	public static Node sortedInsert(Node head, int data) {
		Node curr = head;
		Node newNode = new Node(data);
		if (data <= head.data) {
			newNode.next = head;
			head = newNode;
		}else {
			try {
				while (curr.next != null && curr.next.data < data)
					curr = curr.next;
				newNode.next = curr.next;
				curr.next = newNode;
			} catch (NullPointerException e) {
				System.out.println("Insertion index not valid");
			}
		}

		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		System.out.println("Before");
		printLinkedList(head);

		int data = 25;
		System.out.println("\nAfter insertion of data=" + data);
		Node newHead = sortedInsert(head, data);
		printLinkedList(newHead);

	}

}
