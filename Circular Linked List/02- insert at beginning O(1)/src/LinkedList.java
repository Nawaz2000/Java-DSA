/*
 * Insert a node at the beginning of a linked list
 * 
 * Idea:
 * add the new node after the head and then swap the data between head and the new node
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
	
	public static Node insertAtBeginning(Node head, int data) {
		Node newNode = new Node(data);
		
		// if list is empty, make it the first node
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}else {
			// else add the new node after head and then swap the data in head and the newly
			// inserted node
			newNode.next = head.next;
			head.next = newNode;
			int temp = head.data;
			head.data = newNode.data;
			newNode.data = temp;
			return head;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtBeginning(null, 10);
		head = insertAtBeginning(head, 20);
		head = insertAtBeginning(head, 30);
//		System.out.println(head.data + " " + head.next.data + " " + head.next.next.data);
		System.out.println("Before adding: ");
		printCircularLinkedList(head);
		System.out.println("\n\nAfter adding:");
		head = insertAtBeginning(head, 40);
		printCircularLinkedList(head);

	}

}
