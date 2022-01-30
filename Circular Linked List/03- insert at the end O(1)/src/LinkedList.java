/*
 * Insert a node at the end of a linked list
 * 
 * Idea:
 * Insert a node after the head of the list.
 * Swap the data of head and the new node
 * return the new node as the new head
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
	
	public static Node insertAtTheEnd(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}else {
			newNode.next = head.next;
			head.next = newNode;
			
			int t = head.data;
			head.data = newNode.data;
			newNode.data = t;
			return newNode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtTheEnd(null, 10);
		head = insertAtTheEnd(head, 20);
		head = insertAtTheEnd(head, 30);
		System.out.println("Before insertion:");
		printCircularLinkedList(head);
		System.out.println("\nAfter insertion:");
		head = insertAtTheEnd(head, 40);
		printCircularLinkedList(head);

	}

}
