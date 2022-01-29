/*
 * Linked List insertion at any index
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
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

	public static Node insertAtAnyIndex(Node head, int data, int pos) {
		Node curr = head;
		int currPos = 1;
		Node newNode = new Node(data);
		if (pos == 1) {
			newNode.next = head;
			head = newNode;
		}else {
			try {
				while (currPos++ < pos-1)
					curr = curr.next;
				newNode.next = curr.next;
				curr.next = newNode;
			} catch (NullPointerException e) {
				System.out.println("Insertion index not valid");
			}
		}

		return head;
	}

	public static void printLinkedList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		System.out.println("Before");
		printLinkedList(head);

		int pos = 5;
		int data = 5;
		System.out.println("\nAfter insertion of data=" + data + " at pos=" + pos);
		Node newHead = insertAtAnyIndex(head, data, pos);
		printLinkedList(newHead);

	}

}
