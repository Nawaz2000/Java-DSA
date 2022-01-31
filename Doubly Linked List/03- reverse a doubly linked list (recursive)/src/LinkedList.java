/*
 * Recursive reverse a doubly linked list
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 * Space complexity: O(n)
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
	// prints the linked list
	public static void printLinkedList(Node head) {
		if (head == null)
			return;
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
	// inserts node at the end
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
	
	public static Node reverse(Node curr, Node prev) {
		if (curr == null)
			return prev;
		
		// for storing the next element before the next pointer of curr is pointed towards
		// something else
		Node temp = curr.next;
		
		// for the first time when head is passed, prev is null
		if (prev == null) {
			curr.next = curr.prev;
			curr.prev = temp;			
		}else {			
			curr.next = prev;
			curr.prev = temp;
		}
		
		return reverse(temp, curr);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = insertAtEnd(null, 10);
		head = insertAtEnd(head, 20);
		head = insertAtEnd(head, 30);
		System.out.println("Before reversal...");
		printLinkedList(head);
		
		head = reverse(head, null);
		System.out.println("\nAfter reversal...");
		printLinkedList(head);

	}

}
